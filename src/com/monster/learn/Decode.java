package com.monster.learn;

public class Decode {

	// 100.00%
	public int[] decode(int[] encoded, int first) {
		int[] ret = new int[encoded.length + 1];
		ret[0] = first;
		for (int i = 0; i < encoded.length; i++) {
			ret[i + 1] = encoded[i] ^ ret[i];
		}
		return ret;

	}	
	
}
