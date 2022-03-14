package com.monster.learn;

public class IsThree {

	//100%
	public boolean isThree(int n) {
		int count = 2;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
        count++;
        if (n / i < n && n / i != i) {
          count++;
        }
				if (count > 3) {
					return false;
				}
			}
		}
		return count == 3;
	}

}
