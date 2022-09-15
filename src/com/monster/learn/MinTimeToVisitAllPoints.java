package com.monster.learn;

public class MinTimeToVisitAllPoints {
	//90.18%
	public int minTimeToVisitAllPoints(int[][] points) {
		int count = 0;
		if (points.length < 2) {
			return 0;
		}
		int[] pre = points[0];
		for (int i = 1; i < points.length; i++) {
			int[] cur = pre;
			while (cur[0] != points[i][0] || cur[1] != points[i][1]) {
				if (points[i][0] == cur[0]) {
					count += Math.abs(points[i][1] - cur[1]);
					cur = points[i];
				} else if (points[i][1] == cur[1]) {
					count += Math.abs(points[i][0] - cur[0]);
					cur = points[i];
				} else {
					if (points[i][0] > cur[0]) {
						if (points[i][1] > cur[1]) {
							count++;
							cur[0] += 1;
							cur[1] += 1;
						} else {
							count++;
							cur[0] += 1;
							cur[1] -= 1;
						}
					} else {
						if (points[i][1] > cur[1]) {
							count++;
							cur[0] -= 1;
							cur[1] += 1;
						} else {
							count++;
							cur[0] -= 1;
							cur[1] -= 1;
						}
					}
				}
			}
			pre = points[i];
		}
		return count;
	}

	public static void main(String[] args) {
		MinTimeToVisitAllPoints mtap = new MinTimeToVisitAllPoints();
		mtap.minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}});
	}
}
