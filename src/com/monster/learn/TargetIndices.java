package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {
	//59.57%
	public List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				ret.add(i);
			}
			if (nums[i] > target) {
				break;
			}
		}
		return ret;
	}	
}
