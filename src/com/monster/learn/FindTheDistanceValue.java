package com.monster.learn;

import java.util.Arrays;

public class FindTheDistanceValue {

	//32.77%
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		Arrays.sort(arr2);
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			boolean has = true;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] >= arr2[j]) {
					if (arr1[i] - arr2[j] <= d) {
						has = false;
						break;
					}
				} else {
					if (arr2[j] <= d + arr1[i]) {
						has = false;
						break;
					}
				}
			}
			if (has) {
				count++;
			}
		}
		return count;
	}	

}
