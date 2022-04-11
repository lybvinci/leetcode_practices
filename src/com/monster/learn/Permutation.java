package com.monster.learn;

import java.util.HashSet;

public class Permutation {
	//6.01%
	public String[] permutation(String s) {
		HashSet<String> sets = new HashSet<>();
		helper(s.toCharArray(), sets, new HashSet<>(), 0, new StringBuilder());
		String[] ret = new String[sets.size()];
		sets.toArray(ret);
		return ret;

	}	

	private void helper(char[] arr, HashSet<String> sets, HashSet<Integer> indexes, int index, StringBuilder sb) {
		if (sb.length() == arr.length) {
			sets.add(sb.toString());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (indexes.contains(i)) {
				continue;
			} else {
				indexes.add(i);
				sb.append(arr[i]);
				helper(arr, sets, indexes, i + 1, sb);
				sb.deleteCharAt(sb.length() - 1);
				indexes.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		Permutation p = new Permutation();
		p.permutation("abc");
	}


}
