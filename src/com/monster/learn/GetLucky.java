package com.monster.learn;

public class GetLucky {
	//12.88%
	public int getLucky(String s, int k) {
		String s1 = "";
		for (char c : s.toCharArray()) {
			s1 += (int)(c - 'a') + 1;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = 0;
			for (char c : s1.toCharArray()) {
				sum += c - '0';
			}
			s1 = "" + sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		GetLucky gl = new GetLucky();
		gl.getLucky("leetcode", 2);
	}
}
