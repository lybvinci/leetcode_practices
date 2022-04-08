package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindWinners {
	//31.63%
	public List<List<Integer>> findWinners(int[][] matches) {
		HashMap<Integer, Integer> mapWinners = new HashMap<>();
		HashMap<Integer, Integer> mapLosers = new HashMap<>();
		for (int i = 0; i < matches.length; i++) {
			mapWinners.put(matches[i][0], mapWinners.getOrDefault(matches[i][0], 0) + 1);
			mapLosers.put(matches[i][1], mapLosers.getOrDefault(matches[i][1], 0) + 1);
		}
		List<Integer> ans1 = new ArrayList<>();
		for (int key : mapWinners.keySet()) {
			if (!mapLosers.containsKey(key)) {
				ans1.add(key);
			}
		}
		List<Integer> ans2 = new ArrayList<>();
		for (int key : mapLosers.keySet()) {
			if (mapLosers.get(key) == 1) {
				ans2.add(key);
			}
		}
		Collections.sort(ans1);
		Collections.sort(ans2);
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(ans1);
		ret.add(ans2);
		return ret;
	}	
}
