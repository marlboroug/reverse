package suffix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
	private PriorityQueue<Integer> minHeap = null;
	private PriorityQueue<Integer> maxHeap = null;
	public MyPriorityQueue(){
		Comparator<Integer> maxHeapComparator = new maxHeapComparator();
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(11, maxHeapComparator);
	}
	public void addNewNumber(int num){
		if (minHeap.size() == maxHeap.size()){// max num > = min num
			if (minHeap.peek() != null && num > minHeap.peek()){
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			} else {
				maxHeap.offer(num);
			}
		} else {
			if (num < maxHeap.peek()){
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}
	public double getMeidan(){
		if (maxHeap.isEmpty()){
			return 0;
		}
		if (maxHeap.size() == minHeap.size()){
			return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}
