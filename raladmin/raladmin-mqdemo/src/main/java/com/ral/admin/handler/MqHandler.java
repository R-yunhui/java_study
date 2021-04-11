/*
 * @projectName raladmin
 * @package com.ral.admin.handler
 * @className com.ral.admin.handler.MqHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

import com.ral.admin.ex.ConsumerMqException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.rabbitmq.client.Channel;
import com.ral.admin.config.MqConfig;
import com.ral.admin.dao.MqMsgDao;
import com.ral.admin.pojo.MqMsgDo;
import com.ral.admin.util.ThreadUtil;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * MqHandler
 *
 * @author renyunhui
 * @version 1.0
 * @Description Mq处理类
 * @date 2021/4/9 15:06
 */
@Component
@Slf4j
public class MqHandler implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static final ListeningExecutorService ERROR_EXECUTOR_SERVICE = MoreExecutors.listeningDecorator(ThreadUtil.createThreadPool("error-thread-pool-"));

    private static final ListeningExecutorService MSG_EXECUTOR_SERVICE = MoreExecutors.listeningDecorator(ThreadUtil.createThreadPool("work-thread-pool-"));

    private final RabbitTemplate rabbitTemplate;
    private final MqMsgDao mqMsgDao;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public MqHandler(RabbitTemplate rabbitTemplate, MqMsgDao mqMsgDao, RedisTemplate<String, String> redisTemplate) {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate = rabbitTemplate;
        this.mqMsgDao = mqMsgDao;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 发送消息到指定的路由键
     *
     * @param exchange 转发器
     * @param routeKey 路由键
     * @param msg      消息
     */

    public void sendMsg(String exchange, String routeKey, String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setCorrelationId(IdUtil.fastSimpleUUID());
        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), messageProperties);
        rabbitTemplate.send(exchange, routeKey, message);
        log.info("发送消息:" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "topic_queue01", durable = "true"),
                    exchange = @Exchange(value = "topic_exchange", type = ExchangeTypes.TOPIC),
                    key = "routing_key_one")}
    )
    public void receiverMqExchange(Channel channel, Message message) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            Object o = redisTemplate.opsForValue().get(message.getMessageProperties().getCorrelationId());
            if (null == o) {
                String msg = new String(message.getBody(), StandardCharsets.UTF_8);
                redisTemplate.opsForSet().add(message.getMessageProperties().getCorrelationId(), msg);
                log.info("接收到topic_routing_key_one消息:{}", msg);
                //发生异常
                int random = ThreadLocalRandom.current().nextInt(10);
                if (random < 2) {
                    log.error("消息处理异常");
                    throw new ConsumerMqException("消息处理异常");
                }
                // 告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("该条数据:{}已经被消费过,请勿重新消费", message.getMessageProperties().getCorrelationId());
        } catch (Exception e) {
            log.error("接收消息失败");
            // 重新放入队列 多次失败重新放回会导致队列堵塞或死循环问题
            // 解决方案，批量剔除此消息，然后记录到db中去补偿  第二个参数可选批量 第三个参数 是否重写入队
            channel.basicNack(deliveryTag, false, false);
            dealError(message);
            // 拒绝消息
            // channel.basicReject(deliveryTag, false);
        }
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "topic_queue02", durable = "true"),
                    exchange = @Exchange(value = "topic_exchange", type = ExchangeTypes.TOPIC),
                    key = "routing_key_two")})
    public void receiverMqExchangeTwo(String msg) {
        log.info("接收到topic_routing_key_two消息:{}", msg);
    }


    @RabbitListener(queues = MqConfig.FANOUT_QUEUE_ONE)
    public void receiverMqFanout(String msg, Channel channel, Message message) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("接收到队列fanout_queue_one消息:{}", msg);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            // 多次失败重新放回会导致队列堵塞或死循环问题 丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.error("接收消息失败");
        }
    }

    @RabbitListener(queues = MqConfig.FANOUT_QUEUE_TWO)
    public void receiverMqFanoutTwo(String msg) {
        log.info("接收到队列fanout_queue_two消息:{}", msg);
    }

    /**
     * 确认消息是否发送到exchange
     *
     * @param correlationData 回调消息的相关数据
     * @param b               ack - true  nack - false
     * @param cause           可选错误原因 可能为空
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String cause) {
        // correlationData.getId() -> 回调的消息id 唯一标识
        if (b) {
            log.info("消息发送成功");
            return;
        }
        log.info("消息发送到exchange失败,错误原因为:" + cause);
    }

    /**
     * 消息消费发生异常时回调
     *
     * @param message    返回的消息
     * @param replyCode  回复代码
     * @param replyText  回复文本
     * @param exchange   交换器
     * @param routingKey routingKey路由密钥
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息消费异常,消息ID：【{}】 消息主体:【{}】 回复信息为:【{}】 【{}】 交换器：【{}】 路由键：【{}】",
                message.getMessageProperties().getCorrelationId(), message, replyCode, replyText, exchange, routingKey);
    }

    /**
     * 消息处理异常
     */
    private void dealError(Message message) {
        ListenableFuture<Object> listenableFuture = ERROR_EXECUTOR_SERVICE.submit(() -> {
            log.debug("接收消息:{} 处理失败,剔除此消息,将此次处理失败的消息入库后续进行补偿流程", message.getMessageProperties().getCorrelationId());
            mqMsgDao.insert(MqMsgDo.builder()
                    .msgId(message.getMessageProperties().getCorrelationId()).
                            msg(new String(message.getBody(), StandardCharsets.UTF_8)).build());
            return "Mq消息异常处理成功";
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object o) {
                log.info("Mq消息异常处理成功：{}", o);
            }

            @Override
            public void onFailure(@Nullable Throwable throwable) {
                log.error("Mq消息异常处理失败:" + throwable);
            }
        }, ERROR_EXECUTOR_SERVICE);
    }
}
