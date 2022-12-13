package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class DivingBoard {
	//5.40%
	public int[] divingBoard(int shorter, int longer, int k) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i <= k; i++) {
			if (i <= 0 && k - i <= 0) {
				continue;
			}
			set.add(i * shorter + longer * (k - i));
		}
		ArrayList<Integer> ret = new ArrayList<>(set);
		Collections.sort(ret);
		int[] result = new int[ret.size()];
		for (int i = 0; i < ret.size(); i++) {
			result[i] = ret.get(i);
		}
		return result;
	}	
}
