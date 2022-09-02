package com.monster.learn;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
	//72.23%
	public String decodeMessage(String key, String message) {
		Map<Character, Character> map = new HashMap<>();
		char start = 'a';
		for (char c : key.toCharArray()) {
			if (c == ' ') {
				continue;
			}
			if (!map.containsKey(c)) {
				map.put(c, start);
				start++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : message.toCharArray()) {
			if (c == ' ') {
				sb.append(c);
			} else {
				sb.append(map.get(c));
			}
		}
		return sb.toString();
	}
}
