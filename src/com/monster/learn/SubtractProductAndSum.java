package com.monster.learn;

public class SubtractProductAndSum {
	//100.00%
	public int subtractProductAndSum(int n) {
		int sum = 0;
		long product = 1;
		while (n != 0) {
			int left = n % 10;
			n /= 10;
			sum += left;
			if (product != 0) {
				product *= left;
			}
		}
		return (int)(product - sum);
	}
}
