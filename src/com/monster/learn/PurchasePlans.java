package com.monster.learn;

import java.util.Arrays;

public class PurchasePlans {
	//95.86%
	private final int SEP = 1000000007;
	public int purchasePlans(int[] nums, int target) {
		Arrays.sort(nums);
		long count = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				count += right - left;
				left++;
			}
		}
		
		return (int)(count % SEP);
	}	

}
