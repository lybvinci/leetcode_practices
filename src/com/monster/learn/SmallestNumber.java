package com.monster.learn;

import java.util.Arrays;

public class SmallestNumber {

	//9.47%
	public long smallestNumber(long num) {
		if (num == 0) {
			return 0;
		}
		boolean f = false;
		if (num < 0) {
			f = true;
			num = -num;
		}
		String s = "";
		while (num != 0) {
			s += num % 10;
			num /= 10;
		}
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		long ret = 0;
		if (f) {
			StringBuilder sb = new StringBuilder();
			sb.append(chars);
			ret = -Long.parseLong(sb.reverse().toString());
		} else {
			int index = 0;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] != '0') {
					index = i;
					break;
				}
			}
			s = "" + chars[index];
			for (int i = 0; i < chars.length; i++) {
				if (i == index) {
					continue;
				}
				s += chars[i];
				ret = Long.parseLong(s);
			}
		}
		return ret;

	}

}
