package JAIO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import JBIO.Calculator;

public class SReadHandler implements CompletionHandler<Integer, ByteBuffer> {  
    //���ڶ�ȡ�����Ϣ�ͷ���Ӧ��  
    private AsynchronousSocketChannel channel;  
    public SReadHandler(AsynchronousSocketChannel channel) {  
            this.channel = channel;  
    }  
    //��ȡ����Ϣ��Ĵ���  
    @Override  
    public void completed(Integer result, ByteBuffer attachment) {  
        //flip����  
        attachment.flip();  
        //����  
        byte[] message = new byte[attachment.remaining()];  
        attachment.get(message);  
        try {  
            String expression = new String(message, "UTF-8");  
            System.out.println("�������յ���Ϣ: " + expression);  
            String calrResult = null;  
            try{  
                calrResult = Calculator.cal(expression).toString();  
            }catch(Exception e){  
                calrResult = "�������" + e.getMessage();  
            }  
            //��ͻ��˷�����Ϣ  
            doWrite(calrResult);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
    }  
    //������Ϣ  
    private void doWrite(String result) {  
        byte[] bytes = result.getBytes();  
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);  
        writeBuffer.put(bytes);  
        writeBuffer.flip();  
        //�첽д���� ������ǰ���readһ��  
        channel.write(writeBuffer, writeBuffer,new CompletionHandler<Integer, ByteBuffer>() {  
            @Override  
            public void completed(Integer result, ByteBuffer buffer) {  
                //���û�з����꣬�ͼ�������ֱ�����  
                if (buffer.hasRemaining())  
                    channel.write(buffer, buffer, this);  
                else{  
                    //�����µ�Buffer  
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);  
                    //�첽��  ����������Ϊ������Ϣ�ص���ҵ��Handler  
                    channel.read(readBuffer, readBuffer, new SReadHandler(channel));  
                }  
            }  
            @Override  
            public void failed(Throwable exc, ByteBuffer attachment) {  
                try {  
                    channel.close();  
                } catch (IOException e) {  
                }  
            }  
        });  
    }  
    @Override  
    public void failed(Throwable exc, ByteBuffer attachment) {  
        try {  
            this.channel.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}