package com.monster.learn;

public class MinArray {

	//100.00%
	public int minArray(int[] numbers) {
		if (numbers.length == 1) {
			return numbers[0];
		}
		int pre = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < pre) {
				return numbers[i];
			}
		}
		return numbers[0];
	}	

}
