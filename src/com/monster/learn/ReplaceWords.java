package com.monster.learn;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReplaceWords {

	//16.22%
	public String replaceWords(List<String> dictionary, String sentence) {
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}		
		});
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			boolean has = false;
			for (String s : dictionary) {
				if (words[i].startsWith(s)) {
					has = true;
					sb.append(s);
					if (i != words.length - 1) {
						sb.append(' ');
					}
					break;
				}
			}
			if (!has) {
				sb.append(words[i]);
			  if (i != words.length - 1) {
				  sb.append(' ');
				}
			}
		}
		return sb.toString();
	}	

}
