package com.monster.learn;

import java.util.Arrays;

public class MajorityElement17_10 {

	//38.66%
	public int majorityElement(int[] nums) {
		if (nums.length <= 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		final int min = nums.length % 2 == 0 ? nums.length / 2 + 1 : nums.length / 2 + 1;
		int pre = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == pre) {
				count++;
				if (count >= min) {
					return nums[i];
				}
			} else {
				if (count >= min) {
					return nums[i];
				}
				pre = nums[i];
				count = 1;
			}
		}
		return -1;
	}	

}
