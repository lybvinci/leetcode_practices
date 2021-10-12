package com.monster.learn;

public class CanArrange {
	//57.56%
	public boolean canArrange(int[] arr, int k) {
		int[] mod = new int[k];
		for (int i = 0; i < arr.length; i++) {
			int key = (arr[i] % k + k) % k;
			mod[key]++;
		}
		if (mod[0] % 2 != 0) {
			return false;
		}
		for (int i = 1; i <= k / 2; i++) {
			if (mod[i] != mod[k-i]) {
				return false;
			}
		}
		return true;
	}	

	public static void main(String[] args) {
		CanArrange ca = new CanArrange();
		ca.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3);
	}
}
