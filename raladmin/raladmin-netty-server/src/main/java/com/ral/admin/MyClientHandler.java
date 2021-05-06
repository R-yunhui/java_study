/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.MyClientHandler
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
 * MyClientHandler
 * @Description
 * @author renyunhui
 * @date 2021/3/18 11:45
 * @version 1.0
 */
@Slf4j
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送消息到服务端
        ctx.writeAndFlush(Unpooled.copiedBuffer("歪比巴卜~茉莉~Are you good~马来西亚~", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收服务端发送过来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("收到服务端:{}发送的消息:{}", ctx.channel().remoteAddress(), byteBuf.toString(CharsetUtil.UTF_8));
    }
}
