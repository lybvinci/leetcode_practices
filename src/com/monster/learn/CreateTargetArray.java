package com.monster.learn;

import java.util.LinkedList;

public class CreateTargetArray {

	//6.28%
	public int[] createTargetArray(int[] nums, int[] index) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(index[i], nums[i]);
		}
		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}

}
