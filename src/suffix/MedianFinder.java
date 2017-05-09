package suffix;

import java.util.PriorityQueue;

public class MedianFinder {
	  /** initialize your data structure here. */
    private PriorityQueue<Integer> pqmax = null;
    private PriorityQueue<Integer> pqmin = null;
    public MedianFinder() {
        pqmax = new PriorityQueue<Integer>((a, b) -> b - a);// store num <= median
        pqmin = new PriorityQueue<Integer>();// store num > meidan
    }
    
    public void addNum(int num) {
        if (pqmax.size() == pqmin.size()) {
        	if (pqmax.size() == 0) {
        		pqmax.offer(num);
        		return;
        	} 
            if (num > pqmin.peek()) {
                pqmax.offer(pqmin.poll());
                pqmin.offer(num);
            } else {
                pqmax.offer(num);
            }
        } else {// pqmax bigger than pqmin
            if (num < pqmax.peek()) {
                pqmin.offer(pqmax.poll());
                pqmax.offer(num);
            } else {
                pqmin.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (pqmax.size() == pqmin.size()) {
            return (double)(((double)pqmax.peek() + (double)pqmin.peek())/ 2.0);
        } else {
            return (double)pqmax.peek();
        }
    }
}
