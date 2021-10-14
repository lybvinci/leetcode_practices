package com.monster.learn;

public class CountNegatives {
	//100.00%
	public int countNegatives(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] < 0) {
					count += grid[0].length - j;
					break;
				}
			}	
		}
		return count;
	}	
}
