package com.monster.learn;

public class ReplaceSpaces {
	//26.71%
	public String replaceSpaces(String S, int length) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (S.charAt(i) == ' ') {
				ret.append("%20");
			} else {
				ret.append(S.charAt(i));
			}
		}
		return ret.toString();
	}	
}
