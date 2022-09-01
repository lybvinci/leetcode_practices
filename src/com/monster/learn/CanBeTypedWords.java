package com.monster.learn;

import java.util.HashSet;

//77.03%
public class CanBeTypedWords {
	public int canBeTypedWords(String text, String brokenLetters) {
		HashSet<Character> set = new HashSet<>();
		for (char c : brokenLetters.toCharArray()) {
			set.add(c);
		}
		char[] chars = text.toCharArray();
		int count = 0;
		boolean hasWord = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				if (hasWord) {
					count++;
				}
				continue;
			}
			if (set.contains(chars[i])) {
				hasWord = false;
				int j = i + 1;
				for (; j < chars.length; j++) {
					if (chars[j] == ' ') {
						break;
					}
				}
				i = j;
			} else {
				hasWord = true;
			}
		}
		if (hasWord) {
			count++;
		}
		return count;

	}
}
