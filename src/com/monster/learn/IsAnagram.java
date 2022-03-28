package com.monster.learn;

public class IsAnagram {

	//50.41%
	public boolean isAnagram(String s, String t) {
		if (s.equals(t) || s.length() != t.length()) {
			return false;
		}
		int[] sc = new int[26];
	  int[] tc = new int[26];
		for (int i = 0; i < s.length(); i++) {
			sc[s.charAt(i) - 'a']++;
			tc[t.charAt(i) - 'a']++;
		}
		for (int i = 0; i < sc.length; i++) {
			if (sc[i] != tc[i]) {
				return false;
			}
		}
		return true;
	}	

}
