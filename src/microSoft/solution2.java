package microSoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution2 {
	static final int maxn = 110;
	static List<Integer>[] nodes = new List[maxn];
	static int[] nums = new int[maxn];
	static int[] is_leaf = new int[maxn];
	static int[] leaf2n = new int[maxn];
	static int[] n2leaf = new int[maxn];
	static int[] name = new int[maxn];
	static int[] pa  = new int[maxn];
	static int[][] dis = new int[maxn][maxn];
	static int n;
	static int m;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < m; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			List<Integer> list = new ArrayList<>();
			int dange = nums[i];
		    for (int j = 0; j < dange; j++) {
		    	list.add(sc.nextInt());
		    }
		    nodes[i] = list;
		}
		for (int i = 1; i <= n; i++) {
			name[i] = i;
			is_leaf[i] = 0;
		}
		for (int i = 0; i < k; i++) {
			int leaf = sc.nextInt();
			is_leaf[leaf] = 1;
			leaf2n[i] = leaf;// num i index zhi wei leaf;
			n2leaf[leaf] = i;// x xianbaio wei i
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				dis[i][j] = sc.nextInt();
			}
		}
		for (int dep = m - 1; dep > 0; dep--){
				solve(dep);
		}
		pa[nodes[0].get(0)] = 0;	
		for (int i = 1; i <= n; i++) {
			System.out.print(pa[i] + " ");
		}
	}
	public static int next_leaf( List<Integer> list, int i) { 
		while (i < list.size() && is_leaf[list.get(i)] != 1){
			i++;
		}
		return i;
	}
	public static int next_no_leaf( List<Integer> list, int i) { 
		while (i < list.size() && is_leaf[list.get(i)] != 0){
			i++;
		}
/*		if (i < list.size()) 
			is_leaf[list.get(i)] = 1;*/
		return i;
	}
	public static void link_ch_pa(int ch_o, int pa_o) {
		pa[ch_o] = pa_o;
		int cn = name[ch_o];
		name[pa_o] = cn;
		for (int i = 0; i < k; i++){
			dis[n2leaf[cn]][i]--;
			dis[i][n2leaf[cn]]--;
		}
	}
	public static int get_dis(int x, int y){
		int xn = name[x], yn = name[y];
		return dis[n2leaf[xn]][n2leaf[yn]];
	}
	public static void solve(int dep) {
		List<Integer> lo = nodes[dep];// child
		List<Integer> up = nodes[dep - 1]; // father

		int pre = next_leaf(lo, 0);// find next leaf
		int up_i = next_no_leaf(up, 0);// find next father

		link_ch_pa(lo.get(pre), up.get(up_i)); // connect leaf and father

		int next;// next
		while ((next = next_leaf(lo, pre + 1)) != lo.size()){
			int pre_o = lo.get(pre), nex_o = lo.get(next);
			if (get_dis(pre_o, nex_o) != 1)
				up_i = next_no_leaf(up, up_i + 1);
			link_ch_pa(nex_o, up.get(up_i));
			pre = next;
		}
	}
}
/*8 3 5  
1 3 4  
1  
2 3 4  
5 6 7 8  
3 5 6 7 8  
0 3 3 3 3  
3 0 2 4 4  
3 2 0 4 4  
3 4 4 0 2  
3 4 4 2 0*/

//solution2.cpp : Defines the entry point for the console application.
//




//solution2
//rebuildTree.cpp : Defines the entry point for the console application.
//
/*	#include "stdafx.h"
	#include <cstdio>
	#include <cstring>
	#include <vector>
	using namespace std;
	const int maxn = 110;
	int n, m, k;
	vector<int> nodes[maxn];
	int nums[maxn];
	int is_leaf[maxn];
	int dis[maxn][maxn];
	int leaf2n[maxn], n2leaf[maxn];
	int name[maxn];
	int pa[maxn];

	int next_leaf(vector<int> &v, int i){
		while (i < v.size() && is_leaf[v[i]] != 1) 
			i++;
		return i;
	}
	int next_no_leaf(vector<int> &v, int i){
		while (i < v.size() && is_leaf[v[i]] != 0) 
			i++;
		if (i < v.size()) 
			is_leaf[v[i]] = 1;
		return i;
	}

	void link_ch_pa(int ch_o, int pa_o){
		 pa[ch_o] = pa_o;

		int cn = name[ch_o];
		name[pa_o] = cn;

		for (int i = 0; i < k; i++){
			dis[n2leaf[cn]][i]--;
			dis[i][n2leaf[cn]]--;
		}
	}
	int get_dis(int x, int y){
		int xn = name[x], yn = name[y];
		return dis[n2leaf[xn]][n2leaf[yn]];
	}
	void solve(int dep){
		vector<int> &lo = nodes[dep];// child
		vector<int> &up = nodes[dep - 1]; // father

		int pre = next_leaf(lo, 0);// find next leaf
		int up_i = next_no_leaf(up, 0);// find next father

		link_ch_pa(lo[pre], up[up_i]); // connect leaf and father

		int next;// next
		while ((next = next_leaf(lo, pre + 1)) != lo.size()){
			int pre_o = lo[pre], nex_o = lo[next];
			if (get_dis(pre_o, nex_o) != 1)
				up_i = next_no_leaf(up, up_i + 1);
			link_ch_pa(nex_o, up[up_i]);
			pre = next;
		}
	}

int main(){
	 scanf("%d%d%d", &n, &m, &k);
	 for (int i = 0; i < m; i++) 
		 scanf("%d", &nums[i]);
		 for (int i = 0; i < m; i++){
			int n = nums[i];
			for (int j = 0; j < n; j++){
				int x;
				scanf("%d", &x);
				nodes[i].push_back(x);
		  }
	 }
	 memset(is_leaf, 0, sizeof(is_leaf));
	 for (int i = 1; i <= n; i++) 
		name[i] = i;
	 for (int i = 0; i < k; i++){
			int x;
			scanf("%d", &x);
			is_leaf[x] = 1;
			leaf2n[i] = x;
			n2leaf[x] = i;
	 }
	 for (int i = 0; i < k; i++)
	   for (int j = 0; j < k; j++)
			scanf("%d", &dis[i][j]);
	 for (int dep = m - 1; dep > 0; dep--){
		solve(dep);
	 }
	 pa[nodes[0][0]] = 0;	
	 for (int i = 1; i <= n; i++) printf("%d ", pa[i]);
	
	 system("pause");
	 return 0;
}*/

