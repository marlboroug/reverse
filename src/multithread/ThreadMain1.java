package multithread;

/*class Thread1 extends Thread{  
    private String name;  
    public Thread1(String name) {  
       this.name=name;  
    }  
    public void run() {  
        for (int i = 0; i < 5; i++) {  
            System.out.println(name + "运行  :  " + i);  
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
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）  
            if (i ==30) {  
                this.yield();  
            }  
        }  
      
}  
}  
  
public class ThreadMain1 {  
  
    public static void main(String[] args) {  
          
        ThreadYield yt1 = new ThreadYield("张三");  
        ThreadYield yt2 = new ThreadYield("李四");  
        yt1.start();  
        yt2.start();  
    }  
  
}  