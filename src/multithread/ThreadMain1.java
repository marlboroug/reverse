package multithread;

/*class Thread1 extends Thread{  
    private String name;  
    public Thread1(String name) {  
       this.name=name;  
    }  
    public void run() {  
        for (int i = 0; i < 5; i++) {  
            System.out.println(name + "����  :  " + i);  
            try {  
                sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
         
    }  
}*/  
/*public class ThreadMain1 {  
  
    public static void main(String[] args) {  
    	Thread1 mTh1=new Thread1("A");  
    	Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
  
    }  
  
}*/ 
class ThreadYield extends Thread{  
    public ThreadYield(String name) {  
        super(name);  
    }  
   
    @Override  
    public void run() {  
        for (int i = 1; i <= 50; i++) {  
            System.out.println("" + this.getName() + "-----" + i);  
            // ��iΪ30ʱ�����߳̾ͻ��CPUʱ���õ��������������Լ����߳�ִ�У�Ҳ����˭������˭ִ�У�  
            if (i ==30) {  
                this.yield();  
            }  
        }  
      
}  
}  
  
public class ThreadMain1 {  
  
    public static void main(String[] args) {  
          
        ThreadYield yt1 = new ThreadYield("����");  
        ThreadYield yt2 = new ThreadYield("����");  
        yt1.start();  
        yt2.start();  
    }  
  
}  