// package com.monster.learn;

public class NumWays {
	//100%
	public int numWays(int n, int[][] relation, int k) {
		int[][] dp = new int[k + 1][n];
		dp[0][0] = 1; // 表示第0轮传递到编号为0的小朋友的总方案数
		for (int i = 1; i <= k; i++) {
				for (int[] r : relation) {
						dp[i][r[1]] += dp[i - 1][r[0]];
				}
		}
		return dp[k][n - 1];
}

	public static void main(String[] args) {
		NumWays nw = new NumWays();
		nw.numWays(3, new int[][]{{0, 1}, {1, 2}}, 2);
	}
}
