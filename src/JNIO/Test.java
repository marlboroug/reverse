package JNIO;

import java.util.Random;
import java.util.Scanner;

import JNIO.Client;

public class Test {
        //����������  
        @SuppressWarnings("resource")  
        public static void main(String[] args) throws Exception{  
            //���з�����  
            Server.start();  
            //����ͻ������ڷ���������ǰִ�д���  
            Thread.sleep(100);  
            //���пͻ���   
            Client.start();  
            while(Client.sendMsg(new Scanner(System.in).nextLine()));  
        }  
}
