package com.monster.learn;

public class CountGoodSubstrings {
	//87.50%
	public int countGoodSubstrings(String s) {
		int ret = 0;
		if (s.length() < 3) {
			return ret;
		}
		int[] words = new int[26];
		char[] sa = s.toCharArray();
		for (int i = 0; i < s.length() - 2; i++) {
			if (i == 0) {
				words[sa[i] - 'a']++;
				words[sa[i + 1] - 'a']++;
				words[sa[i + 2] - 'a']++;
			} else if (i > 0) {
				words[sa[i - 1] - 'a']--;
				words[sa[i + 2] - 'a']++;
			}
			if (words[sa[i] - 'a'] == 1 && words[sa[i + 1] - 'a'] == 1 && words[sa[i + 2] - 'a'] == 1) {
				ret++;
			}
		}
		return ret;
	}	
}
