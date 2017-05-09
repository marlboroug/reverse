package suffix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
	  private static  int size;
	    private Queue<Integer> qu;
	    private Map<Integer, Integer> map;
	    public LRUCache(int capacity) {
	        size = capacity;
	        qu = new LinkedList<Integer>();
	        map = new HashMap<Integer, Integer>();
	    }

	    public int get(int key) {
	        if (map.containsKey(key)) {
	            return map.get(key);
	        } else {
	            return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	        qu.offer(key);
	        if (qu.size() > size) {
	            int key1 = qu.poll();
	            map.remove(key1);
	        }
	         map.put(key, value);
	    }
}
