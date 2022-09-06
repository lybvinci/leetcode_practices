package com.monster.learn;

public class SumOddLengthSubarrays {
	//43.50%
	public int sumOddLengthSubarrays(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for (int start = 0; start < n; start++) {
				for (int length = 1; start + length <= n; length += 2) {
						int end = start + length - 1;
						for (int i = start; i <= end; i++) {
								sum += arr[i];
						}
				}
		}
		return sum;
	}
}
