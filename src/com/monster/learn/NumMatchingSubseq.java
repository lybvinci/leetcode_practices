package com.monster.learn;

public class NumMatchingSubseq {

	//5.16%
	public int numMatchingSubseq(String s, String[] words) {
		int ret = 0;
		for (String word : words) {
			char[] charArray = word.toCharArray();
			int j = 0;
			for (int i = 0; i < s.length(); i++) {
				int index = s.indexOf(charArray[j],i);
				if (index != -1) {
					i = index;
					if (s.charAt(i) == charArray[j]) {
						j++;
						if (j >= charArray.length) {
							break;
						}
					}
				} else {
					break;
				}
				
			}
			if (j >= charArray.length) {
				ret++;
			}
		}
		return ret;
	}	

}
