package com.monster.learn;

public class GetNoZeroIntegers {
	//54.11%
	public int[] getNoZeroIntegers(int n) {
		for (int i = 1; i < n; i++) {
			if (("" + i).contains("0")) {
				continue;
			}
			int left = n - i;
			if (("" + left).contains("0")) {
				continue;
			}
			return new int[]{i, left};
		}
		return null;
	}
}
