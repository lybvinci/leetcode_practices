package com.monster.learn;

//33.57%
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j -1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }  
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}