package reseversting;

import java.util.LinkedList;
import java.util.Queue;

public class MyMath {
	public int getKNum(int k){
		if (k < 0){
			return 0;
		}
		Queue<Integer> quene3 = new LinkedList<Integer>();
		Queue<Integer> quene5 = new LinkedList<Integer>();
		Queue<Integer> quene7 = new LinkedList<Integer>();
		quene3.add(1);
		int val = 1;
		for (int i = 0; i < k; i++){
			int v3 = quene3.size() > 0 ? quene3.peek() : Integer.MAX_VALUE;
			int v5 = quene5.size() > 0 ? quene5.peek() : Integer.MAX_VALUE;
			int v7 = quene7.size() > 0 ? quene7.peek() : Integer.MAX_VALUE;
			val = (int)Math.min(v3, Math.min(v5, v7));
			if (val == v3){
				quene3.remove();
				quene3.add(3 * val);
				quene5.add(5 * val);	
			}  else if (val == v5){
				quene5.remove();
				quene5.add(5 * val);
			} else {
				quene7.remove();
			}
			quene7.add(7 * val);
		}	
		return val;
	}
}
