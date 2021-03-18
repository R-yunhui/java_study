/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.NettyDemo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * NettyDemo
 * @Description
 * @author renyunhui
 * @date 2021/3/18 11:06
 * @version 1.0
 */
@Slf4j
public class MyNettyServer {

    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程组 默认线程数为 cpu核心数 * 2
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务端的启动对象 设置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    // 设置两个线程组
                    .group(bossGroup, workerGroup)
                    // 设置服务端通道实现类型
                    .channel(NioServerSocketChannel.class)
                    // 设置现场队列得到的连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 使用匿名内部类的形式初始化通道对象
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 给pipeline管道设置处理器
                            socketChannel.pipeline().addLast(new MyServerHandler());
                        }
                    });// 给workerGroup的EventLoop对应的管道设置处理器
            log.info("java技术爱好者的服务端已经准备就绪..");
            //绑定端口号，启动服务端
            ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 释放掉所有的资源，包括创建的线程
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
