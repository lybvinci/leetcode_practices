package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays {
	//55.49%
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> ret = new ArrayList<>();

		for (int i = 0; i < l.length; i++) {
			int startIndex = l[i];
			int endIndex = r[i];
			int[] tmp = new int[endIndex - startIndex + 1];
			if (tmp.length < 2) {
				ret.add(true);
				continue;
			}
			for (int j = 0; j <= tmp.length; j++) {
				tmp[j] = nums[startIndex + j];
			}
			Arrays.sort(tmp);
			int cha = tmp[1] - tmp[0];
			boolean success = true;
			for (int j = 2; j < tmp.length; j++) {
				if (tmp[j] - tmp[j-1] == cha) {
					continue;
				} else {
					success = false;
					break;
				}
			}
			ret.add(success);
		}

		return ret;
	}	
}
