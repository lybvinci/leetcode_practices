package com.monster.learn;

public class CountServers {
	//99.53%
	public int countServers(int[][] grid) {
		int ret = 0;
	  int[] rowCount = new int[grid.length];
		int[] columnCount = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					columnCount[j]++;
					rowCount[i]++;
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && (rowCount[i] > 1 || columnCount[j] > 1)) {
					ret++;
				}
			}
		}

		return ret;
	}	
}
