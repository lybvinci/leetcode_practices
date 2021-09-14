package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {
	//5.04%
	public int findPairs(int[] nums, int k) {
		List<String> list = new ArrayList<>();
		List<Integer> dump = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (dump.contains(nums[i])) {
				continue;
			}
			dump.add(nums[i]);
			for (int j = i+1; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) == k) {
					String tmp = nums[i] + "-" + nums[j];
					String tmp2 = nums[j] + "-" + nums[i];
					if (!list.contains(tmp) && !list.contains(tmp2)) {
						list.add(tmp);
					}
				}
			}
		}
		return list.size();
	}

	//72.25%
	public int f2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] - nums[i] == k) {
					set.add(nums[i]);
				} else if (nums[j] - nums[i] > k) {
					break;
				}
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		FindPairs fp = new FindPairs();
		fp.f2(new int[]{1,3,1,5,4}, 0);
	}
}