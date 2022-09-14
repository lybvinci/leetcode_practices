package com.monster.learn;

public class FindKthPositive {
	//100.00%
	public int findKthPositive(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				k++;
			}
		}	
		return k;
	}
}
