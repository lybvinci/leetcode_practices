package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class BuildArray1441 {

	//100.00%
	public List<String> buildArray(int[] target, int n) {
		List<String> ret = new ArrayList<>();
		int i = 1;
		for (int num : target) {
			for (; i <=n; i++) {
				if (num == i) {
					ret.add("Push");
					i++;
          break;
				} else {
					ret.add("Push");
					ret.add("Pop");
				}
			}
		}
		return ret;
	}	

}
