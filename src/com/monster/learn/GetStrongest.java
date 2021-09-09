package com.monster.learn;

import java.util.Arrays;

public class GetStrongest {
	//88.19%
	public int[] getStrongest(int[] arr, int k) {
		Arrays.sort(arr);
		int[] ret = new int[k];
		int m = arr[(arr.length - 1)/ 2];
		int start = 0;
		int end = arr.length - 1;
		for (int i = 0; i < k; i++) {
			if (Math.abs(arr[end] - m) >= Math.abs(arr[start] - m)) {
				ret[i] = arr[end];
				end--;
			} else {
				ret[i] = arr[start];
				start++;
			}
		}
		return ret;
	}	
}
