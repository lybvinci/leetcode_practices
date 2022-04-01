package com.monster.learn;

public class Shuffle {
	//100.00%
	public int[] shuffle(int[] nums, int n) {
		int[] ret = new int[nums.length];
		int j = 0;
		for (int i = 0; i < n; i++) {
			ret[j++] = nums[i];
			ret[j++] = nums[i + n];
		}
		return ret;
	}	
}
