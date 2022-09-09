package com.monster.learn;

public class RearrangeArray {
	//99.42%
	public int[] rearrangeArray(int[] nums) {
		int[] z = new int[nums.length / 2];
		int[] f = new int[z.length];
		int zIndex = 0;
		int fIndex = 0;
		for (int num : nums) {
			if (num < 0) {
				f[fIndex++] = num;
			} else {
				z[zIndex++] = num;
			}
		}
		int[] ret = new int[nums.length];
		int index = 0;
		for (int i = 0; i < z.length; i++) {
			ret[index++] =  z[i];
			ret[index++] = f[i];
		}
		return ret;
	}
}
