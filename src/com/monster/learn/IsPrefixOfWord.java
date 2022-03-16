package com.monster.learn;

public class IsPrefixOfWord {
	public int isPrefixOfWord(String sentence, String searchWord) {
		// int index = 0;
		// while ((index = sentence.indexOf(searchWord, index)) != -1) {
		// 	if (index == 0) {
		// 		return 0;
		// 	} else if (sentence.charAt(index - 1) == ' ') {
		// 		return index;
		// 	}
		// }	
		// return -1;
		//100.00%
		String[] arr = sentence.split(" ");
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == " ") {
				continue;
			}
			count++;
			if (arr[i].startsWith(searchWord)) {
				return count;
			}
		}
		return -1;
	}	
}
