package com.monster.learn;

public class MaximumPopulation {

	//47.93%
	public int maximumPopulation(int[][] logs) {
		int[] count = new int[3000];
		for (int i = 0; i < logs.length; i++) {
			for (int j = logs[i][0]; j < logs[i][1]; j++) {
				count[j] = count[j] + 1;
			}
		}
		int max = count[1950];
		int year = 1950;
		for (int i = 1951; i < 2051; i++) {
			if (count[i] > max) {
				max = count[i];
				year = i;
			}
		}
		return year;
	}	

}
