package com.monster.learn;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {
	//89.76%
	public int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				if (sb.length() != 0) {
					while(sb.length() > 1 && sb.charAt(0) == '0') {
						sb.deleteCharAt(0);
					}
					set.add(sb.toString());
					sb.delete(0, sb.length());
				}
			}
		}
		if (sb.length() != 0) {
			while(sb.length() > 1 && sb.charAt(0) == '0') {
				sb.deleteCharAt(0);
			}
			set.add(sb.toString());
		}
		return set.size();
	}	

}
