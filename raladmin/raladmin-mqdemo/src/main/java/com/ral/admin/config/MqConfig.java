/*
 * @projectName raladmin
 * @package com.ral.admin.config
 * @className com.ral.admin.config.MqConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MqConfig
 * @Description rabbitMq的配置类
 * @author renyunhui
 * @date 2021/4/9 14:28
 * @version 1.0
 */
@Configuration
public class MqConfig {

    /** 直接模式队列一 */
    public static final String QUEUE_NAME_ONE = "direct_queue_one";
    /** 订阅者模式队列一 */
    public static final String TOPIC_QUEUE_ONE = "topic_queue_one";
    /** 订阅者模式队列二 */
    public static final String TOPIC_QUEUE_TWO = "topic_queue_two";
    /** 广播模式队列一 */
    public static final String FANOUT_QUEUE_ONE = "fanout_queue_one";
    /** 广播模式队列二 */
    public static final String FANOUT_QUEUE_TWO = "fanout_queue_two";

    /** 订阅模式路由器一 */
    public static final String TOPIC_EXCHANGE_ONE = "topic_exchange_one";
    /** 订阅模式路由器二 */
    public static final String TOPIC_EXCHANGE_TWO = "topic_exchange_two";
    /** 广播模式路由器 */
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    /** 订阅模式路由键一 */
    public static final String TOPIC_ROUTE_KEY_ONE = "topic_key_one";
    /** 订阅模式路由键二 */
    public static final String TOPIC_ROUTE_KEY_TWO = "topic_key_two";

    @Bean
    public Queue directQueue() {
        // direct模式队列  持久化
        return new Queue(QUEUE_NAME_ONE, true);
    }

    @Bean
    public Queue topicQueueOne() {
        // topic模式队列  持久化
        return new Queue(TOPIC_QUEUE_ONE, true);
    }

    @Bean
    public Queue topicQueueTwo() {
        // topic模式队列  持久化
        return new Queue(TOPIC_QUEUE_TWO, true);
    }

    @Bean
    public Queue fanoutQueueOne() {
        // fanout模式队列  持久化
        return new Queue(FANOUT_QUEUE_ONE, true);
    }

    @Bean
    public Queue fanoutQueueTwo() {
        // fanout模式队列  持久化
        return new Queue(FANOUT_QUEUE_TWO, true);
    }

    @Bean
    public TopicExchange topicExchangeOne() {
        // topic交换器 默认持久化
        return new TopicExchange(TOPIC_EXCHANGE_ONE);
    }

    @Bean
    public TopicExchange topicExchangeTwo() {
        // topic交换器 默认持久化
        return new TopicExchange(TOPIC_EXCHANGE_TWO);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        // fanout交换器 默认持久化
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding topicBindingOne() {
        // 订阅模式绑定
        return BindingBuilder.bind(topicQueueOne()).to(topicExchangeOne()).with(TOPIC_ROUTE_KEY_ONE);
    }

    @Bean
    public Binding topicBindingTwo() {
        // 订阅模式绑定
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchangeTwo()).with(TOPIC_EXCHANGE_TWO);
    }

    @Bean
    public Binding fanoutBindingOne() {
        // 广播模式绑定
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingTwo() {
        // 广播模式绑定
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }
}
