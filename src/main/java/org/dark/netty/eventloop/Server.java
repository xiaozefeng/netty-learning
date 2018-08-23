package org.dark.netty.eventloop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

/**
 * @author xiaozefeng
 * @date 2018/8/23 上午11:37
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        // 相当于 /Users/xiaozefeng/git-repo/netty-learning/src/main/java/org/dark/nativesocket/Server.java 的循环线程
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        // 相当于 /Users/xiaozefeng/git-repo/netty-learning/src/main/java/org/dark/nativesocket/Client.java 的循环调用
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boosGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childAttr(AttributeKey.newInstance("childAttr"), "childAttrValue")
                    .handler(new ServerHandler())
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                        }
                    });
            ChannelFuture future= b.bind(8888).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
