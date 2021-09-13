package com.monster.learn;

import java.util.Arrays;

public class MaximumRemovals {
	//68.10%
	public int maximumRemovals(String s, String p, int[] removable) {
		int left = 0;
		int right = removable.length + 1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (check(s, p, mid, removable)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private boolean check(String s, String p, int mid, int[] removable) {
		boolean[] valid = new boolean[s.length()];
		Arrays.fill(valid, true);
		for (int i = 0; i < mid; i++) {
			valid[removable[i]]	= false;
		}
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (valid[j] && s.charAt(j) == p.charAt(i)) {
				i++;
				if (i == p.length()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MaximumRemovals mr = new MaximumRemovals();
		mr.maximumRemovals("abccb", "abc", new int[]{0,1,2,3,4});
	}

}
