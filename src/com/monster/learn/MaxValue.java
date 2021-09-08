package com.monster.learn;

public class MaxValue {

	//51.71%
	public static String maxValue(String n, int x) {
		boolean isNegative = false;
		if (n.startsWith("-")) {
			isNegative = true;
			n = n.substring(1);
		}
		int insertIndex = n.length();
		for (int i = 0; i < n.length(); i++) {
			if (isNegative) {
				if ((int) (n.charAt(i) - '0') > x) {
					insertIndex = i;
					break;
				}
			} else {
				if ((int) (n.charAt(i) - '0') < x) {
					insertIndex = i;
					break;
				}
			}
		}
		if (insertIndex >= n.length()) {
			n = n + x;
		} else if (insertIndex == 0) {
			n = x + n;
		} else {
			n = n.substring(0, insertIndex) + x + n.substring(insertIndex);
		}
		return isNegative ? '-' + n : n;
	}	

	public static void main(String[] args) {
		MaxValue.maxValue("-132", 3);
	}
}
