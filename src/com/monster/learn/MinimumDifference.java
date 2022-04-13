package com.monster.learn;

import java.util.Arrays;

public class MinimumDifference {

	//99.98%
	public int minimumDifference(int[] nums, int k) {
		Arrays.sort(nums);
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i <= nums.length - k; i++) {
			ret = Math.min(ret, nums[i + k - 1] - nums[i]);
		}
		return ret;
	}	

}
