package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	//100.00%
	List<List<Integer>> list;
	public List<List<Integer>> subsets(int[] nums) {
		list = new ArrayList<>();
		dfs(nums.length - 1, nums, new ArrayList<>());
		return list;
	}

	private void dfs(int n, int[] nums, List<Integer> ret) {
		if (n < 0) {
			list.add(new ArrayList<Integer>(ret));
			return;
		}
		ret.add(nums[n]);
		dfs(n - 1, nums, ret);
		ret.remove(ret.size() - 1);
		dfs(n - 1, nums, ret);
	}

	public static void main(String[] args) {
		Subsets ss = new Subsets();
		ss.subsets(new int[]{1,2,3});
	}

}
