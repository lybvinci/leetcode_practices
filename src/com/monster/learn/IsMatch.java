package com.monster.learn;

public class IsMatch {
	//99.45%
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starPos = -1; // *号位置
		int match = -1; // 匹配*用
		while (i < s.length()) {
			// 当前两个字符是否相同
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			}
			// 匹配到星号
			else if (j < p.length() && p.charAt(j) == '*') {
				match = i;
				starPos = j;
				j = starPos + 1;
			}
			// 星号没有匹配成功
			else if (starPos != -1) {
				match++;
				i = match;
				j = starPos + 1;
			} else {
				return false;
			}
		}
		// abcd
		// a*d*
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}

		return j == p.length();
	}
}
