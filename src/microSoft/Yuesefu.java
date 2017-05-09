package microSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Yuesefu {
	public static List<List>  resu = new ArrayList<List>();
	public static void main(String[] args) { 
		Stack<Object> st = new Stack<Object>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		reverse(st);
		String s = "***abcd*egf";
		System.out.println(move(s));
		TreeSet tree = new TreeSet();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(5);
		System.out.println();
	}
	public static int move(String str) {
		int a = xx;
		if (str == null || str.length() < 1) return 0;
		char[] temp = str.toCharArray();
		int count = 0;
		int i = 1;
		while (i < temp.length) {
			while (temp[i]  == '*' && count < i){
				swap(temp, count, i);
				count++;
			} 
			i++;
		}
		System.out.println(Arrays.toString(temp));
		return count;
	}
	public static void swap(char[] ch, int x, int y) {
		char tge = ch[x];
		ch[x] = ch[y];
		ch[y] = tge;
	}
	public static void reverse (Stack<Object> st) {
		if (st == null || st.size() == 0) return ;
		Object o = st.pop();
		reverse(st);
		putToButtom(st, o);
	}
	public static void putToButtom(Stack<Object> st , Object o) {
		if (st.size() == 0){
			st.push(o);
			return;
		}
		Object te = st.pop();
		putToButtom(st, o);
		st.push(te);
	}
	// 最长公共子串
	public static int logSube2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1) return 0;
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				} else {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				}
			}
		}
		return  dp[m][n];
	}
	public static int lonSubse(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1) return 0;
		int[][] temp = new int[s1.length()][s2.length()];
		return dfs(temp, 0, 0, s1, s2);
	}
	public static int dfs(int[][] temp, int id1, int id2, String s1, String s2) {
		if (id1 >= s1.length() || id2 >= s2.length()) return 0;
		if (temp[id1][id2] > 0) return temp[id1][id2];
		int max = Integer.MIN_VALUE;
		if (s1.charAt(id1) == s2.charAt(id2)) {
			max = Math.max(dfs(temp, id1 + 1, id2 + 1, s1, s2) + 1, dfs(temp, id1, id2 + 1, s1, s2));
			max = Math.max(max , dfs(temp, id1 + 1, id2, s1, s2));
		} else {
			max = max = Math.max(dfs(temp, id1 + 1, id2, s1, s2), dfs(temp, id1, id2 + 1, s1, s2));
		}
		temp[id1][id2] = max;
		return max;
	}
	public static void dfs(int beg, int end, int tar, List<Integer> list) {
		if (tar == 0) {
			resu.add(new ArrayList<Integer>(list));
			return;
		}
		if (beg > end) return; 
		for (int i = beg; i <= end; i++) {
			list.add(i);
			int min = Math.min(end, tar - i);
			dfs(i + 1, min, tar - i , list);
			list.remove(list.size() - 1);
		}
	}
}
