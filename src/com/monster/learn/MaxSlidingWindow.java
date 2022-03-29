package com.monster.learn;

public class MaxSlidingWindow {

	//17.95%
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length < 1) {
			return new int[0];
		}
		int[] ret = new int[nums.length - k + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			max = Math.max(max, nums[i]);
		}
		ret[0] = max;
		for (int i = 1; i < nums.length && i + k - 1 < nums.length; i++) {
			max = Integer.MIN_VALUE;
			for (int j = i; j < i + k; j++) {
				max = Math.max(max,nums[j]);
			}
			ret[i] = max;
		}
		return ret;
	}	
}
