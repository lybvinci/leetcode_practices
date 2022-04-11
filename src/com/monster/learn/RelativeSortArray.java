package com.monster.learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class RelativeSortArray {

	//26.20%
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for (int i : arr1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int j = 0;
		for (int i : arr2) {
			if (map.containsKey(i)) {
				int count = map.get(i);
				while(count-- != 0) {
					arr1[j++] = i;
				}
				map.remove(i);
			}
		}
		for (int key : map.keySet()) {
				int count = map.get(key);
				while(count-- != 0) {
					arr1[j++] = key;
				}
		}
		return arr1;

	}	

}
