package JAIO;

import java.util.Scanner;

public class TEST {
	  //����������  
    @SuppressWarnings("resource")  
    public static void main(String[] args) throws Exception{  
        //���з�����  
        Server.start();  
        //����ͻ������ڷ���������ǰִ�д���  
        Thread.sleep(100);  
        //���пͻ���   
        Client.start();  
        System.out.println("������������Ϣ��");  
        Scanner scanner = new Scanner(System.in);  
        while(Client.sendMsg(scanner.nextLine()));  
    }
}
