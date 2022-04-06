package com.monster.learn;

import java.util.Arrays;

public class CheckIfCanBreak {
	//44.27%
	public boolean checkIfCanBreak(String s1, String s2) {
		char[] sa1 = s1.toCharArray();
		char[] sa2 = s2.toCharArray();
		Arrays.sort(sa1);
		Arrays.sort(sa2);
		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 0; i < sa1.length; i++) {
			if (sa1[i] == sa2[i]) {
				continue;
			} else if (sa1[i] > sa2[i]) {
				flag2 = false;
				if (!flag1) {
					return false;
				}
			} else {
				flag1 = false;
				if (!flag2) {
					return false;
				}
			}
		}
		return true;
	}	
}
