package com.monster.learn;

public class MaximumDifference {

	//13.58%
	public int maximumDifference(int[] nums) {
		int ret = -1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					ret = Math.max(ret, nums[j] - nums[i]);
				}
			}
		}
		return ret;
	}	

}
