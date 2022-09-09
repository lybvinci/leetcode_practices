package com.monster.learn;

import java.util.HashSet;

public class FindSubarrays {
	//87.80%
	public boolean findSubarrays(int[] nums) {
		HashSet<Integer> sums = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 >= nums.length) {
				break;
			}
			int sum = nums[i] + nums[i + 1];
			if (sums.contains(sum)) {
				return true;
			}
			sums.add(sum);
		}
		return false;
	}
}
