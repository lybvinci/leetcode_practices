package com.monster.learn;

public class NextGreatestLetter {

	//100.00%
	public char nextGreatestLetter(char[] letters, char target) {
		char ret = letters[0];
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] > target) {
				ret = letters[i];
				break;
			}
		}
		return ret;
	}	

}
