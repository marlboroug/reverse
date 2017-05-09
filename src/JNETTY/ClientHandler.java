package JNETTY;

import io.netty.buffer.ByteBuf;  
import io.netty.buffer.Unpooled;  
import io.netty.channel.ChannelHandlerContext;  
import io.netty.channel.ChannelInboundHandlerAdapter;  
import java.io.UnsupportedEncodingException;  
public class ClientHandler extends ChannelInboundHandlerAdapter {  
    ChannelHandlerContext ctx;  
    /** 
     * tcp��·�����ɹ������ 
     */  
    @Override  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
        this.ctx = ctx;  
    }  
    public boolean sendMsg(String msg){  
        System.out.println("�ͻ��˷�����Ϣ��"+msg);  
        byte[] req = msg.getBytes();  
        ByteBuf m = Unpooled.buffer(req.length);  
        m.writeBytes(req);  
        ctx.writeAndFlush(m);  
        return msg.equals("q")?false:true;  
    }  
    /** 
     * �յ���������Ϣ����� 
     * @throws UnsupportedEncodingException  
     */  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {  
        ByteBuf buf = (ByteBuf) msg;  
        byte[] req = new byte[buf.readableBytes()];  
        buf.readBytes(req);  
        String body = new String(req,"utf-8");  
        System.out.println("��������Ϣ��"+body);  
    }  
    /** 
     * �����쳣ʱ���� 
     */  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
        ctx.close();  
    }  
}  