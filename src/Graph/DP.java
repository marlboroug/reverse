package Graph;

import java.util.Arrays;

public class DP {
	// 
	 public static void main(String args[]){
	     int arr[] = {2, 11, 13, 5, 6, 7};
	     System.out.println(getMax(arr));
	     System.out.println(PredictTheWinner(arr));
	     System.out.println(getMoney(arr));
	 }
	 public static int getMax(int[] nums) {
		 //if
		 int m = nums.length;
		 int[][] dp = new int[m + 1][m + 1];
		 for (int i = 1; i <= m; i++) {
			 dp[i][i] = nums[i - 1];
		 }
		 int[] sum = new int[m + 1];
		 for (int i = 1; i <= m; i++) {
			 sum[i] = sum[i - 1] + nums[i - 1]; 
		 }
		 for (int len = 1; len < m; len++) {
			 for (int i = 1; i <= m; i++) {
				 int j = i + len;
				 if (j > m) continue;
				 int temp1 = nums[i - 1] + sum[j] - sum[i] - dp[i + 1][j];
				 int temp2 = nums[j - 1] + sum[j - 1] - sum[i - 1] - dp[i][j - 1]; 
				 dp[i][j] = Math.max(temp1, temp2);
			 }
		 }
		 return dp[1][m];
	 }

	 public static int getMoney(int[] nums) {
		 // if
		 int m = nums.length;
		 int[][][] memo = new int[m + 1][m + 1][2];
		 int[] resu =  dfs(memo,nums, 0, m - 1, 0 );
		 System.out.println(Arrays.toString(resu));
		 return resu[0];
	 }
	 public static int[] dfs(int[][][] memo, int [] nums, int le, int ri, int num) {
		 int[] resu = new int[2];
		 if (le == ri) {
			 if (num == 0) {
				 resu[0] = nums[le]; 
				 resu[1] = 0; 
			 } else {
				 resu[0] = 0; 
				 resu[1] = nums[le]; 
			 }
			 return resu;
		 }
		 if (memo[le][ri][num] > 0) {
			 return memo[le][ri];
		 }
		 if (num == 0) {
			 int temp1[] = dfs(memo, nums, le + 1, ri, 1);
			 int max1 = temp1[0] + nums[le];
			 int temp2[] = dfs(memo, nums, le, ri - 1, 1);
			 int max2 = temp1[0] + nums[ri];
			 if (max1 >  max2) {
				 temp1[0] = temp1[0] + nums[le];
				 memo[le][ri] = temp1;
				 return temp1;
			 } else {
				 temp2[0] = temp2[0] + nums[ri];
				 memo[le][ri] = temp2;
				 return temp2;
			 }
		 }
		 if (num == 1) {
			 int temp1[] = dfs(memo, nums, le + 1, ri, 0);
			 int max1 = temp1[1] + nums[le];
			 int temp2[] = dfs(memo, nums, le, ri - 1, 0);
			 int max2 = temp1[1] + nums[ri];
			 if (max1 >  max2) {
				 temp1[1] = temp1[1] + nums[le];
				 memo[le][ri] = temp1;
				 return temp1;
			 } else {
				 temp2[1] = temp2[1] + nums[ri];
				 memo[le][ri] = temp2;
				 return temp2;
			 }
		 }
		 return null;
	 }
}
