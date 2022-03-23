package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLonely {
	//85.97%
	public List<Integer> findLonely(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		if (nums.length == 0) {
			return ret;
		} else if (nums.length < 2) {
			ret.add(nums[0]);
			return ret;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i + 1] > nums[i] + 1) {
					ret.add(nums[i]);
				}
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1] + 1) {
					ret.add(nums[i]);
				}
			} else {
				if (nums[i] > nums[i - 1] + 1 && nums[i] + 1 < nums[i + 1]) {
					ret.add(nums[i]);
				}
			}
		}	
		return ret;
	}	
}
