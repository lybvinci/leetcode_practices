package com.monster.learn;

import java.util.Arrays;

public class TwoSum {

	//42.64%
	public int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int maybe = target - numbers[i];
			int maybeIndex = Arrays.binarySearch(numbers, maybe);
			if (maybeIndex >= 0 && maybeIndex != i) {
				ret[0] = Math.min(i, maybeIndex);
				ret[1] = Math.max(i, maybeIndex);
			}
		}
		return ret;
	}	

}
