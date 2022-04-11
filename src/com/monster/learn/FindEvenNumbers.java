package com.monster.learn;

import java.util.Arrays;
import java.util.HashSet;

public class FindEvenNumbers {

	//66.38%
	public int[] findEvenNumbers(int[] digits) {
		HashSet<Integer> hasThird = new HashSet<>();

		HashSet<Integer> ret = new HashSet<>();
		for (int i = 0; i < digits.length; i++) {
			int test = digits[i];
			if (hasThird.contains(test) || test % 2 != 0) {
				continue;
			}
			hasThird.add(test);
		  HashSet<Integer> hasSecond = new HashSet<>();
			for (int j = 0; j < digits.length; j++) {
				if (hasSecond.contains(digits[j]) || j == i) {
					continue;
				}
				hasSecond.add(digits[j]);
				test += digits[j] * 10;
		    HashSet<Integer> hasFirst = new HashSet<>();
				for (int k = 0; k < digits.length; k++) {
					if (hasFirst.contains(digits[k]) || digits[k] == 0 || k == j || k == i) {
						continue;
					}
					hasFirst.add(digits[k]);
					test += digits[k] * 100;
					ret.add(test);
					test -= digits[k] * 100;
				}
				test -= digits[j] * 10;
			}
		}
		int[] retArray = ret.stream().mapToInt(i -> i.intValue()).toArray();
		Arrays.sort(retArray);
		return retArray;
	}	

	public static void main(String[] args) {
		FindEvenNumbers fen = new FindEvenNumbers();
		fen.findEvenNumbers(new int[]{2,1,3,0});
	}


}
