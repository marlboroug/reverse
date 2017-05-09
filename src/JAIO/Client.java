package JAIO;

import java.util.Scanner;

public class Client {  
    private static String DEFAULT_HOST = "127.0.0.1";  
    private static int DEFAULT_PORT = 13;  
    private static AsyncClientHandler clientHandle;  
    private static AsyncClientHandler clientHandle1;  
    private static AsyncClientHandler clientHandle2;  
    private static AsyncClientHandler clientHandle3;  
    private static AsyncClientHandler clientHandle4;  
    private static AsyncClientHandler clientHandle5;  
    public static void start(){  
        start(DEFAULT_HOST,DEFAULT_PORT);  
    }  
    public static synchronized void start(String ip,int port){  
        if(clientHandle!=null)  
            return;  
        clientHandle = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle,"Client").start();  
        clientHandle1 = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle1,"Client").start(); 
        clientHandle2 = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle2,"Client").start(); 
        clientHandle3 = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle3,"Client").start(); 
        clientHandle4 = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle4,"Client").start(); 
        clientHandle5 = new AsyncClientHandler(ip,port);  
        new Thread(clientHandle5,"Client").start(); 
    }  
    //向服务器发送消息  
    public static boolean sendMsg(String msg) throws Exception{  
        if(msg.equals("q")) return false;  
        clientHandle.sendMsg(msg);  
        clientHandle1.sendMsg(msg);  
        clientHandle2.sendMsg(msg);  
        clientHandle3.sendMsg(msg);  
        clientHandle4.sendMsg(msg);  
        clientHandle5.sendMsg(msg);  
        return true;  
    }  
    @SuppressWarnings("resource")  
    public static void main(String[] args) throws Exception{  
        Client.start();  
        System.out.println("请输入请求消息：");  
        Scanner scanner = new Scanner(System.in);  
        while(Client.sendMsg(scanner.nextLine()));  
    }  
}  
