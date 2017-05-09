package reseversting;
import java.util.*;
public class nums3 {
	static long resu;
	public static void main(String[] args) {
		/* Scanner si = new Scanner(System.in);
	        int n = si.nextInt();
	        int k = si.nextInt();
	        int t = n - k - 1;
	        resu = 0;
	        dfs(new LinkedList<Integer>(), n,k, t );*/
	        System.out.println( 1.34 * 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34  * 1.34 * 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34* 1.34);
	        System.out.println( 2.34 * 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34 * 2.34 * 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34* 2.34);
       
    }
	public static void dfs(List<Integer> list, int max,int m, int n){
		if (list.size() == max) {
			for(int i = 0; i < max - 1; i++) {
				if (list.get(i)< list.get(i + 1)) {
					m--;
					if (m < 0 ) return;
				} else {
					n--;
					if (n < 0 ) return;
				}
			}
			resu++;
		}
		for (int i = 1; i <= max; i++) {
			if (!list.contains(i)) {
				list.add(i);
				dfs(list, max, m, n);
				list.remove(list.size() - 1);
			}
		}
	}
}