package com.monster.learn;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSplit {

	//5.11%
	private int max = 1;
	public int maxUniqueSplit(String s) {
		if (null == s || s.length() <= 1) {
			return s.length();
		}
		max = 1;
		find(s, 0, new HashSet<>());
		return max;
	}	

	private void find(String s, int start, Set<String> set) {
		if (start >= s.length()) {
			max = Math.max(max, set.size());
			return;
		}
		if (max >= set.size() + s.length() - start) {
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String tmp = "";
			for (int j = i; j < s.length(); j++) {
				tmp += s.charAt(j);
				if (!set.contains(tmp)) {
					set.add(tmp);
					find(s, j + 1, set);
					set.remove(tmp);
				}
			}
		}
	}

}
