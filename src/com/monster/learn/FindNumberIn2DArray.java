package com.monster.learn;

public class FindNumberIn2DArray {

	//100.00%
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				} else if (matrix[i][j] > target) {
					break;
				}
			}
		}	
		return false;

	}	

	public static void main(String[] args) {
		FindNumberIn2DArray fni2d = new FindNumberIn2DArray();
		fni2d.findNumberIn2DArray(new int[][]{{2,5},{2,8},{7,9},{7,11},{9,11}}, 7);
	}

}
