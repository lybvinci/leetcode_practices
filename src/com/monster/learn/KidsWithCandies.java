package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

	//79.53%
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			List<Boolean> ret = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			for (int i : candies) {
				if (i > max) {
					max = i;
				}
			}
			for (int i : candies) {
				ret.add(i + extraCandies >= max);
			}
			return ret;
	}

}
