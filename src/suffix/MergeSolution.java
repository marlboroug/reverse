package suffix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSolution {
	 public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) return null;
	        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
	            @Override
	            public int compare(ListNode o1,ListNode o2){
	                if (o1.val < o2.val)
	                    return -1;
	                else if (o1.val==o2.val)
	                    return 0;
	                else 
	                    return 1;
	            }
	        });
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail = dummy;
	        
	        ListNode nodes = null;
	        System.out.println("****");
	        for (int i = 0; i < lists.length; i++) {
	            nodes = lists[i];
	            while (nodes != null) {
	                queue.offer(nodes);
	                nodes = nodes.next;    
	            }
	        } 
	       while (!queue.isEmpty()){
	            tail.next=new ListNode(queue.poll().val);
	            tail=tail.next;
	            
	          /*  if (tail.next!=null)
	                queue.add(tail.next);*/
	        }
	        return dummy.next;
	    }
}
