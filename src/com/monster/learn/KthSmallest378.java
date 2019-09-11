package com.monster.learn;

import java.util.Arrays;

//45.65%
public class KthSmallest378 {
    public int kthSmallest(int[][] matrix, int k) {
        int[] all = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                all[i + i * j] = matrix[i][j];
            }
        }
        Arrays.sort(all);
        return all[k - 1];
    }
}