package com.monster.learn;

import java.util.Arrays;

public class GetLeastNumbers {

	//68.65%
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		int[] ret = new int[k];
		int j = 0;
		for (int i = 0; i < arr.length && j < k; i++) {
			ret[j++] = arr[i];
		}
		return ret;
	}	

}
