package com.monster.learn;

//100.00%
public class CanThreePartsEqualSum {

	public boolean canThreePartsEqualSum(int[] arr) {
		long sum = 0;
		for (int i : arr) {
			sum += i;
		}
		if (sum % 3 != 0) {
			return false;
		}
		long avg = sum / 3;
		int left = 0;
		int right = arr.length - 1;
		long leftSum = arr[left];
		long rightSum = arr[right];
		while (left + 1 < right) {
			if (leftSum == avg && rightSum == avg) {
				return true;
			}
			if (leftSum != avg) {
				left++;
				leftSum += arr[left];
			}
			if (rightSum != avg) {
				right--;
				rightSum += arr[right];
			}
		}
		return false;
	}
	
}
