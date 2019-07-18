package com.monster.learn;

// 87.79%
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) j++;
            else i--;
        }
        return false;
    }
}