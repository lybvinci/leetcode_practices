package com.monster.learn;

public class AreNumbersAscending {
	//90.73%
	public boolean areNumbersAscending(String s) {
		String[] items = s.split(" ");
		int pre = -1;
		for (String item : items) {
			if (item.isEmpty()) {
				continue;
			}
			if (item.charAt(0) >= '0' && item.charAt(0) <= '9') {
				int current = Integer.parseInt(item);
				if (current <= pre) {
					return false;
				}
				pre = current;
			}
		}
		return true;
	}
}
