package com.monster.learn;

import java.util.Arrays;

public class MaxOperations {
	//98.49%
	public int maxOperations(int[] nums, int k) {
		int ret = 0;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int sum = 0;
		while (left < right) {
			sum = nums[left] + nums[right];
			if (sum == k) {
				ret++;
				left++;
				right--;
			} else if (sum > k) {
				right--;
			} else {
				left++;
			}
		}
		return ret;
	}	
}
