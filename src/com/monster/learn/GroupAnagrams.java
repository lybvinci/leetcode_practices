package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
	//5.07%
	public List<List<String>> groupAnagrams(String[] strs) {
		String[] copy = new String[strs.length];	
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			copy[i] = new String(arr);
		}
		List<List<String>> ans = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < copy.length; i++) {
			if (set.contains(i)) {
				continue;
			}	
			set.add(i);
			List<String> item = new ArrayList<>();
			item.add(strs[i]);
			for (int j = i + 1; j < copy.length; j++) {
				if (set.contains(j)) {
					continue;
				}
				if (copy[i].equals(copy[j])) {
					item.add(strs[j]);
					set.add(j);
				}
			}
			ans.add(item);
		}
		return ans;

	}	
}
