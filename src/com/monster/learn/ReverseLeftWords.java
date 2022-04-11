package com.monster.learn;

public class ReverseLeftWords {

	//100.00%
	public String reverseLeftWords(String s, int n) {
		String left = s.substring(0, n);
		String right = s.substring(n, s.length());
		return right + left;
	}	

}
