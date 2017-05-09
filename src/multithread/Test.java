package multithread;

import java.util.concurrent.ThreadPoolExecutor;



public class Test extends Thread{
    
	private Object self;     
    private Test(Object self) {     
        this.self = self;     
    }  
    
    public void run() {     
        synchronized (self) {   
					System.out.println("init");   
					System.out.println("reach the state of wait"); 
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					self.notify();
					System.out.println("reach the state of release");   
					System.out.println("note ");
           
        }     
    }     

    public static void main(String[] args) throws Exception { 
    	ThreadPoolExecutor pool = new ThreadPoolExecutor();
        Object a = new Object();     
        Object b = new Object();    
    	Test test = new Test(a);
        synchronized (a) {
        	test.start();
        	System.out.println("before wait ***");

           	a.wait();
        	System.out.println("after wait");
        }  
    }     
}  
