package com.monster.learn;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {
	//95.88%
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 1; i <= n; i++) {
				if (i > arr[i - 1]) return Math.min(i, arr[n - 1]);
		}
		return n;
}

}
