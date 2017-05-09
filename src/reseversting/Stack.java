package reseversting;

import java.util.LinkedList;
import java.util.Queue;

public class Stacks {
	  private Queue<Integer> inquene = new LinkedList<Integer>();
	    private Queue<Integer> outquene = new LinkedList<Integer>();
	    int temp =0;
	    // Push element x onto stack.
	    public void push(int x) {
	        inquene.add(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	      if( inquene.isEmpty()){
	    	  while( !outquene.isEmpty() ){
	    		  temp = outquene.peek();
	    		  outquene.poll();
	    		  if( !outquene.isEmpty() ){
	    			  inquene.add(temp);
	    		  }
	    	  }
	    	 
	    	  
	      }else{
	            while(  !inquene.isEmpty() ){
	            	 temp = inquene.peek();
		    		  inquene.poll();
		    		  if( !inquene.isEmpty() ){
		    			  outquene.add(temp);
		    		  }
	            }
	        }
	    }

	    // Get the top element.
	    public int top() {
	      
	        if( inquene.isEmpty() ){
	        	while( !outquene.isEmpty() ){
		    		  temp = outquene.peek();
		    		  outquene.poll();
		    	  }
	        	return temp;
	        }else{
	        	 while(  !inquene.isEmpty() ){
	            	temp = inquene.peek();
		    		inquene.poll();
		    		outquene.add(temp);
	            }
	        	 return temp;
	        }
	        
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return inquene.isEmpty()&&outquene.isEmpty();
	    }
}
