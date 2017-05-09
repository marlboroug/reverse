package suffix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		int[] info = new int[]{0,1, 2, 3, 1, 5};
		int[] cost = new int[]{0,2, 1, 3, 1, 4};
		int nif = 4;
		int[][] dp = new int[info.length + 1][cost.length + 1];
		for (int i = 0; i <= nif; i++) {
			dp[0][i] = Integer.MAX_VALUE;//表示不可达。
		}
		for (int i = 0; i <= 5; i++) {
			dp[i][0] = cost[i];
		}
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= nif; j++) {
				if (j <= info[i]) {
					dp[i][j] = Math.min(dp[i - 1][j], cost[i]);
				} else {
					if (dp[i - 1][j - info[i]] == Integer.MAX_VALUE) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - info[i]] + cost[i]);
					}
				}
			}
		}
		System.out.println(Arrays.toString(dp[0]));
		System.out.println(Arrays.toString(dp[1]));
		System.out.println(Arrays.toString(dp[2]));
		System.out.println(Arrays.toString(dp[3]));
		System.out.println(Arrays.toString(dp[4]));
		System.out.println(Arrays.toString(dp[5]));
		System.out.println(dp[5][4]);
 	}
}
