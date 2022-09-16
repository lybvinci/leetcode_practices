package com.monster.learn;

import java.util.Arrays;

public class IsStraight {
	//27.24%
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int zeroCount = 0;
		int cha = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				zeroCount = i + 1;
				break;
			}
			if (i > 0 && nums[i - 1] != 0) {
				if (nums[i] == nums[i - 1]) {
					return false;
				}
				cha += nums[i] - nums[i - 1] - 1;
			}
		}
		return zeroCount >= cha;
	}

	public static void main(String[] args) {
		IsStraight is = new IsStraight();
		is.isStraight(new int[]{1,2,3,4,5});
	}
}
