package com.monster.learn;

public class CheckOverlap {
	// 100%
	public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
		int x, y;
		if (x_center > x2) {
			x = x2;
		} else if (x_center < x1) {
			x = x1;
		} else {
			x = x_center;
		}
		if (y_center > y2) {
			y = y2;
		} else if (y_center < y1) {
			y = y1;
		} else {
			y = y_center;
		}
		double distance = Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2);
		return distance <= radius * radius;
	}	
}
