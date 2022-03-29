package com.monster.learn;

public class FindNumbers {

	//24.15%
	public int findNumbers(int[] nums) {
		int ret = 0;
		for (int num : nums) {
			if ((num + "").length() % 2 == 0) {
				ret++;
			}
		}
		return ret;
	}	

}
