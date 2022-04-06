package com.monster.learn;

import java.util.HashMap;

public class MaxAbsoluteSum {
	//37.75%
	public int maxAbsoluteSum(int[] nums) {
		int max = 0, min = 0;
		int res = 0;
		for (int num : nums) {
				max = Math.max(max + num, num);
				min = Math.min(min + num, num);
				res = Math.max(res, Math.max(Math.abs(max), Math.abs(min)));
		}
		return res;

	}	
}
