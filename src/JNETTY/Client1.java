package JNETTY;

import io.netty.bootstrap.Bootstrap;  
import io.netty.channel.ChannelFuture;  
import io.netty.channel.ChannelInitializer;  
import io.netty.channel.ChannelOption;  
import io.netty.channel.EventLoopGroup;  
import io.netty.channel.nio.NioEventLoopGroup;  
import io.netty.channel.socket.SocketChannel;  
import io.netty.channel.socket.nio.NioSocketChannel;  

import java.util.Scanner;  
public class Client1 implements Runnable{  
    static ClientHandler client = new ClientHandler();  
    public static void main(String[] args) throws Exception {  
        new Thread(new Client1()).start();  
        @SuppressWarnings("resource")  
        Scanner scanner = new Scanner(System.in);  
        while(client.sendMsg(scanner.nextLine()));  
    } 
    public static boolean sendMsg(String s) {
    	return client.sendMsg(s);
    } 
    @Override  
    public void run() {  
        String host = "127.0.0.1";  
        int port = 9090;  
        System.out.println("¿Í»§¶Ë¿ªÆô£º" + port);
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
        try {  
            Bootstrap b = new Bootstrap();  
            b.group(workerGroup);  
            b.channel(NioSocketChannel.class);  
            b.option(ChannelOption.SO_KEEPALIVE, true);  
            b.handler(new ChannelInitializer<SocketChannel>() {  
                @Override  
                public void initChannel(SocketChannel ch) throws Exception {  
                    ch.pipeline().addLast(client);  
                }  
            });  
            ChannelFuture f = b.connect(host, port).sync();  
            f.channel().closeFuture().sync();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } finally {  
            workerGroup.shutdownGracefully();  
        }  
    }  
}  