package com.monster.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountCharacters {
	//45.83%
	// not use map. 80.42%
	public int countCharacters(String[] words, String chars) {
		int[] alpha = new int[26];
		for (int i = 0; i < chars.length(); i++) {
			alpha[chars.charAt(i) - 'a']++;
		}
		// HashMap<String, Boolean> map = new HashMap<>();
		int count = 0;
		for (String s : words) {
			char[] sc = s.toCharArray();
			// Arrays.sort(sc);
			// String sortedS = new String(sc);
			// if (map.containsKey(sortedS)) {
			// 	if (map.get(sortedS)) {
			// 		count += sortedS.length();
			// 	}
			// } else {
				int[] alpha1 = new int[26];
				System.arraycopy(alpha, 0, alpha1, 0, alpha.length);
				boolean success = true;
				for (char c : sc) {
					alpha1[c - 'a']--;
					if (alpha1[c-'a'] < 0) {
						success = false;
						break;
					}
				}	
				if (success) {
					count += s.length();
				}
			// 	map.put(sortedS, success);
			// }
		}
		return count;
	}

	public static void main(String[] args) {
		CountCharacters cc = new CountCharacters();
		cc.countCharacters(new String[]{"cat","bt","hat","tree"},"atach");
	}
}
