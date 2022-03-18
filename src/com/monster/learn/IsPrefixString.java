package com.monster.learn;

public class IsPrefixString {
	//77.10%
	public boolean isPrefixString(String s, String[] words) {
		String tmp = "";
		for (int i = 0; i < words.length; i++) {
			tmp += words[i];
			if (tmp.length() == s.length()) {
				break;
			} else if (tmp.length() > s.length()) {
				return false;
			}
		}
		return tmp.startsWith(s);
	}	
}
