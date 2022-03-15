package com.monster.learn;

public class SplitString {

  public boolean splitString(String s) {
		char[] ss = s.toCharArray();
		long cur = 0;
		for (int i = 0; i < ss.length - 1; i++) {
			cur = cur * 10 + (ss[i] - '0');
			if (helper(ss, cur, i + 1)) {
				return true;
			}
		}
		return false;
	}	

	private boolean helper(char[] s, long pre, int index) {
		if (index == s.length) {
			return true;
		}
    long cur = 0;
		for (int i = index; i < s.length; i++) {	
			cur = cur * 10 + (s[i] - '0');
			if (cur == pre - 1 && helper(s, cur, i + 1)) {
				return true;
			}
      if (cur >= pre) {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SplitString ss = new SplitString();
		ss.splitString("1234");
	}

}
