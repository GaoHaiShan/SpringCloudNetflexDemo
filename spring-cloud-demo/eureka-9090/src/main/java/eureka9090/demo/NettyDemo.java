package eureka9090.demo;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyDemo {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup main = new DefaultEventLoop();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(main)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });
        ChannelFuture future = bootstrap.bind(8080).sync();
        future.channel().closeFuture().sync();
    }

}
