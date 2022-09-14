package com.monster.learn;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

	//14.44%
	public int findLongestChain(int[][] pairs) {
		int n = pairs.length;
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
						if (pairs[i][0] > pairs[j][1]) {
								dp[i] = Math.max(dp[i], dp[j] + 1);
						}
				}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[][] pairs = new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
		FindLongestChain flc = new FindLongestChain();
		flc.findLongestChain(pairs);
	}
}
