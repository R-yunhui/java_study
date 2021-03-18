/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.MyServerHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * MyServerHandler
 * @Description
 * 自定义的Handler需要继承Netty规定好的HandlerAdapter
 * 才能被Netty框架所关联，有点类似SpringMVC的适配器模式
 * @author renyunhui
 * @date 2021/3/18 11:40
 * @version 1.0
 */
@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 获取客户端发送过来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("收到客户端:{}发送的消息:{}", ctx.channel().remoteAddress(), byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 发送消息给客户端
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(1000L);
                log.info("长时间的其它业务处理.....");
            } catch (InterruptedException e) {
                log.error("任务执行失败:", e);
                Thread.currentThread().interrupt();
            }
        });
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已收到消息，并给你发送一个问号?", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("发生异常,通道关闭");
        // 发生异常，关闭通道
        ctx.close();
    }
}