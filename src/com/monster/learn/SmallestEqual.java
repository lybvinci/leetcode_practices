package com.monster.learn;

public class SmallestEqual {

	//100.00%
	public int smallestEqual(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i % 10 == nums[i]) {
				return i;
			}
		}
		return -1;
	}	

}
