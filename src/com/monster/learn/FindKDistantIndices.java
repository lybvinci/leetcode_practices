package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class FindKDistantIndices {
	//48.69%
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> ret = new ArrayList<>();
		List<Integer> keys = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key) {
				keys.add(i);
			}	
		}	
		if (keys.isEmpty()) {
			return ret;
		}
		for (int i = 0; i < nums.length; i++) {
			for(int item : keys) {
				if (Math.abs(i - item) <= k) {
					ret.add(i);
					break;
				}
			}
		}
		return ret;
	}
}
