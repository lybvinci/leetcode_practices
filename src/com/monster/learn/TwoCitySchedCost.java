package com.monster.learn;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedCost {
	private int min = Integer.MAX_VALUE;

	public int twoCitySchedCost(int[][] costs) {
		min = Integer.MAX_VALUE;
		helper(costs, 0, 0, 0, 0);
		return min;
	}	

	private void helper(int[][] costs, int index, int cost, int countA, int countB) {
		if (index >= costs.length) {
			if (countA == costs.length / 2 && countB == costs.length / 2) {
				min = Math.min(min, cost);
			}
			return;
		}
		for (int i = index; i < costs.length; i++) {
			cost += costs[index][0];
			helper(costs, i + 1, cost, countA + 1, countB);
			cost -= costs[index][0];
      cost += costs[index][1];
			helper(costs, i + 1, cost, countA, countB + 1);
		}
	}

	//99.00%
	public int twoCitySchedCost2(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
						return o1[0] - o1[1] - (o2[0] - o2[1]);
				}
		});

		int total = 0;
		int n = costs.length / 2;
		for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
		return total;
	}

}
