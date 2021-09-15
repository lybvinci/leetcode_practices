package com.monster.learn;

public class IsGoodArray {
	//83.93%
	public boolean isGoodArray(int[] nums) {
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			tmp = gcd(tmp, nums[i]);
		}
		return tmp == 1;
	}	

	private int gcd(int a, int b) {
		if ((a % b) == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}
}
