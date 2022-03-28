package com.monster.learn;

public class IsRobotBounded {

	//100.00%
	public boolean isRobotBounded(String instructions) {
		int d = 0;
		int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		char[] chars = instructions.toCharArray();
		int x = 0;
		int y = 0;
		for (char c : chars) {
			if (c == 'R') {
				d += 1;
			} else if (c == 'L') {
				d += 3;
			} else {
				d = d % 4;
				x += dirs[d][0];	
				y += dirs[d][1];	
			}
		}
		return ((x == 0 && y == 0) || (d % 4 != 0));
	}

}
