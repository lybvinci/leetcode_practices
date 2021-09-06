package com.monster.learn;

import java.util.ArrayList;
import java.util.HashSet;
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


	// 8.24%
	public List<Integer> f2(int n, int start) {
		List<Integer> ret = new ArrayList<>();
		HashSet<Integer> visited = new HashSet<>();

		ret.add(start);
		visited.add(start);
		dfs(n, start, ret, visited);

		return ret;
	}	

	private boolean dfs(int n, int prev, List<Integer> ret, HashSet<Integer> visited) {
		int size = 1 << n;
		if (ret.size() == size) {
			// check is right answer
			int start = ret.get(0);
			int end = ret.get(ret.size() - 1);
			int temp = start ^ end;
			return (temp & (temp - 1)) == 0;
		}
		for (int i = 0; i < n; i++) {
			int next = prev ^ (1 << i);
			if (!visited.contains(next)) {
				visited.add(next);
				ret.add(next);
				if (dfs(n, next, ret, visited)) {
					return true;
				}
				visited.remove(next);
				ret.remove(ret.size() - 1);
			}
		}
		return false;
	}
}
