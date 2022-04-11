package com.monster.learn;

public class MaxAbsValExpr {

	//too slower
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				ret = Math.max(ret,Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j));
			}
		}
		return ret;
	}	

}
