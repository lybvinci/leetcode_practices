package com.monster.learn;

public class MaxValueOffer47 {

	//98.48%
	public int maxValue(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (i == 0 && j > 0) {
					grid[i][j] += grid[i][j - 1];
				} else if (i > 0 && j == 0) {
					grid[i][j] += grid[i - 1][j];
				} else if (i > 0 && j > 0) {
					grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[row - 1][column - 1];
	}
	// tooooo slow
	// public int maxValue(int[][] grid) {
	// 	return helper(grid, 0, 0);
	// }

	// private int helper(int[][] grid, int row, int column) {
	// 	if (row >= grid.length || column >= grid[0].length) {
	// 		return 0;
	// 	}

	// 	int max = 0;
	// 	for (int i = row; i < grid.length; i++) {
	// 		for (int j = column; j < grid[0].length; j++) {
	// 			int sum = grid[i][j];
	// 			int down = sum + helper(grid, i, j + 1);
	// 			int right = sum + helper(grid, i + 1, j);
	// 			max = Math.max(max, down);
	// 			max = Math.max(max, right);
	// 		}
	// 	}
	// 	return max;
	// }
}
