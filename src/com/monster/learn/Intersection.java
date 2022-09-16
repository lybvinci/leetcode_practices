package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Intersection {
	//52.62%
	public List<Integer> intersection(int[][] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int[] num : nums) {
			for (int i : num) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		List<Integer> ret = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == nums.length) {
				ret.add(entry.getKey());
			}
		}
		Collections.sort(ret);
		return ret;
	}
}
