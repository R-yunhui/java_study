/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.MyNettyClient
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * MyNettyClient
 * @Description
 * @author renyunhui
 * @date 2021/3/18 11:44
 * @version 1.0
 */
@Slf4j
public class MyNettyClient {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            // 创建bootstrap对象，配置参数
            Bootstrap bootstrap = new Bootstrap();
            // 设置线程组
            bootstrap.group(eventExecutors)
                    // 设置客户端的通道实现类型
                    .channel(NioSocketChannel.class)
                    // 使用匿名内部类初始化通道
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //添加客户端通道的处理器
                            ch.pipeline().addLast(new MyClientHandler());
                        }
                    });
            log.info("客户端准备就绪，随时可以起飞~");
            // 连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();

            channelFuture.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    log.info("连接成功...");
                } else {
                    log.info("连接失败...");
                }
            });

            // 对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭线程组
            eventExecutors.shutdownGracefully();
        }
    }
}
