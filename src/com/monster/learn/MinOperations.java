package com.monster.learn;

public class MinOperations {
	//30.48%
	public int minOperations(int[] nums) {
		int ret = 0;
		while(true) {
			int numZero = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] % 2 == 1) {
					nums[i]--;
					ret++;
				}
				if (nums[i] == 0) {
					numZero++;
				}
			}
			if (numZero == nums.length) {
				break;
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = nums[i] / 2;
			}
			ret++;
		}
		return ret;
	}	

	private void modify(int[] arr, int op, int idx) {
		if (op == 0) {
			arr[idx] = arr[idx] + 1;
		}
		if (op == 1) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i] * 2;
			}
		}
	}
}
