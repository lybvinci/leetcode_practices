package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HalfQuestions {
	//29.98%
	public int halfQuestions(int[] questions) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < questions.length; i++) {
			map.put(questions[i], map.getOrDefault(questions[i], 0) + 1);
		}
		List<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		int n = questions.length / 2;
		int cnt = 0;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (count >= n) {
				break;
			}
			count += list.get(i);
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		HalfQuestions hq = new HalfQuestions();
		hq.halfQuestions(new int[]{2,1,6,2});
	}
}
