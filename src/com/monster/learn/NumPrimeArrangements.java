package com.monster.learn;

public class NumPrimeArrangements {
	
	//100.00%
	public int numPrimeArrangements(int n) {
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		int cnt = 0;
		for (int prime : primes) {
			if (prime <= n) {
				cnt++;
			}
		}
		long ans = 1;
		final int MOD = (int)1e9 + 7;
		for (int i = 1; i <= cnt; i++) {
			ans = ans * i % MOD;
		}
		for (int i = 1; i <= n - cnt; i++) {
			ans = ans * i % MOD;
		}
		return (int)(ans % MOD);
	}
}
