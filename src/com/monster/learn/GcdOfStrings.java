package com.monster.learn;

public class GcdOfStrings {
	//23.13%
	public String gcdOfStrings(String str1, String str2) {
		String shortStr = str1.length() > str2.length() ? str2 : str1;
		String longStr = str1.length() > str2.length() ? str1 : str2;
		int size = shortStr.length();
		while (size > 0) {
			if (shortStr.length() % size != 0) {
				size--;
				continue;
			}
			String key = shortStr.substring(0, size);
			String temp = key;
			boolean equalShort = false;
			while (temp.length() <= longStr.length()) {
				if (!equalShort && temp.equals(shortStr)) {
					equalShort = true;
				}
				if(temp.equals(longStr)) {
					if (equalShort) {
						return key;
					}
				}
				temp += key;
			}
		  size--;
		}
		return "";
	}	

	public static void main(String[] args) {
		GcdOfStrings gos = new GcdOfStrings();
		gos.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
	}
}
