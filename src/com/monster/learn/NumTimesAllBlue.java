package com.monster.learn;

public class NumTimesAllBlue {
	//5.38%
	public int numTimesAllBlue(int[] light) {
		int ret = 0;
		int start = 1;
		int[] status = new int[light.length];
		for (int i = 0; i < light.length; i++) {
			status[light[i] - 1] = 1;
			for (int j = start; j < light.length + 1; j++) {
				if (status[j - 1] == 1) {
					if (j == start) {
						status[j - 1] = 2;
						start = j + 1;
					} else {
						if (status[j - 2] != 0 && status[j - 1] == 1) {
							status[j - 1] = 2;
							start = j + 1;
						} else {
							break;
						}
					}
				} else {
					break;
				}
			}
			boolean allBlue = true;
			for (int j = start; j < light.length + 1; j++) {
				if (status[j - 1] == 1) {
					allBlue = false;
					break;
				}
			}
			if (allBlue) {
				ret++;
			}
		}
		return ret;
	}
 
	public static void main(String[] args) {
		NumTimesAllBlue ntab = new NumTimesAllBlue();
		ntab.numTimesAllBlue(new int[]{4,1,2,3});
	}
	


}
