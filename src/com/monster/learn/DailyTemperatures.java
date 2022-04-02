package com.monster.learn;

public class DailyTemperatures {

	//6.71%
	public int[] dailyTemperatures(int[] temperatures) {
		int[] ret = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[j] > temperatures[i]) {
					ret[i] = j - i;
					break;
				}				
			}
		}
		return ret;
	}

}
