package com.monster.learn;

public class DistributeCandies {
	//91.20%
	public int[] distributeCandies(int candies, int num_people) {
		int[] ret = new int[num_people];
		int base = 0;
		while (candies > 0) {
			for (int i = 0; i < num_people; i++) {
				if (candies - (base + i + 1) > 0) {
					ret[i] += base + i + 1;
					candies -= base + i + 1;
				} else {
					ret[i] += candies;
					return ret;
				}
			}
			base += num_people;
		}
		return ret;
	}

	public static void main(String[] args) {
		DistributeCandies	dc = new DistributeCandies();
		dc.distributeCandies(7, 4);
	}
}
