package com.monster.learn;

public class DigitSum {
	//17.63%
	public String digitSum(String s, int k) {
		while (s.length() > k) {
			String ns = "";
			for (int i = 0; i < s.length(); i++) {
				int sum = 0;
				for (int j = i; j < i + k; j++) {
					if (j >= s.length()) {
						break;
					}
					sum += s.charAt(j) - '0';
				}
				ns += sum;
			  i = i + k - 1;
			}
			s = ns;
		}
		return s;
	}	
}
