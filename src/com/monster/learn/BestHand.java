package com.monster.learn;

import java.util.HashMap;
import java.util.Map.Entry;

public class BestHand {

	//36.05%
	public String bestHand(int[] ranks, char[] suits) {
		char c = suits[0];
		boolean has = true;
		for (int i = 1; i < suits.length; i++) {
			if (c != suits[i]) {
				has = false;
				break;
			}
		}
		if (has) {
			return "Flush";
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : ranks) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int max = 0;
		for (Entry<Integer, Integer> i : map.entrySet()) {
			max = Math.max(max, i.getValue());
		}
		if (max >= 3) {
			return "Three of a Kind";
		} else if (max >= 2) {
			return "Pair";
		} else {
			return "High Card";
		}
	}

}
