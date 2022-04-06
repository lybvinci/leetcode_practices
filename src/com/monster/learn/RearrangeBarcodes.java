package com.monster.learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class RearrangeBarcodes {

	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] ret = new int[barcodes.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : barcodes) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Comparator.comparing(Map.Entry::getValue));
		int j = 0;
		for (int i = list.size() - 1; i >= 0;) {
			Entry<Integer, Integer> entry = list.get(i);
			ret[j++] = entry.getKey();
			if (j + 1 < ret.length) {
				Entry<Integer, Integer> entry2 = list.get(i-1);
				ret[j++] = entry2.getKey();
				if (entry2.getValue() == 1) {
					i--;
					list.remove(entry2);
				} else {
					entry2.setValue(entry2.getValue() - 1);
				}
			}
			if (entry.getValue() == 1) {
				i--;
				list.remove(entry);
			} else {
				entry.setValue(entry.getValue() - 1);
			}
			list.sort(Comparator.comparing(Map.Entry::getValue));
		}

		return ret;
	}	

	//54.21%
	public int[] rearrangeBarcodes2(int[] barcodes) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int b : barcodes) {
				map.put(b, map.getOrDefault(b, 0) + 1);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
		for (int k : map.keySet()) {
				pq.add(new int[]{k, map.get(k)});
		}
		int[] res = new int[barcodes.length];
		int i = 0;
		while (!pq.isEmpty()) {
				int[] temp = pq.poll();
				while (temp[1] -- > 0) {
						res[i] = temp[0];
						i += 2;
						if (i >= barcodes.length) i = 1;
				}
				
		}
		return res;
  }


}
