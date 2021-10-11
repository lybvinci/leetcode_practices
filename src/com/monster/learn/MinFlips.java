package com.monster.learn;

public class MinFlips {
	//91.72%
	public int minFlips(String target) {
		int res = 0;
		char[] array = target.toCharArray();
		char c = '0';
		for (char ch : array) {
			if (c != ch) {
				res++;
				c = ch;
			}
		}
		return res;
	}
}
