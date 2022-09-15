package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	//47.22%
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> ret = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int cur = i;
			boolean has = true;
			while (cur != 0) {
				if (cur % 10 == 0 || i % (cur % 10) != 0) {
					has = false;
					break;
				}
				cur /= 10;
			}
			if (has) {
				ret.add(i);
			}
		}
		return ret;
	}
}
