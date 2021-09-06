package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//97.65%
public class CircularPermutation {
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> ret = new ArrayList<>();
		int size = 1 << n;
		int[] ans = new int[size];
		for (int i = 0; i < size; i++) {
			ans[i] = i ^ (i >>> 1);
		}
		for (int i = 0; i < size; i++) {
			if (ans[i] == start) {
				for (int j = 0; j < size; j++) {
					ret.add(ans[(i + j) % size]);
				}
			}
		}
		return ret;
	}	
}
