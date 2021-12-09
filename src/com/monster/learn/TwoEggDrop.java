package com.monster.learn;

//21.60%
public class TwoEggDrop {

    public int twoEggDrop(int n) {
        int[][] dp = new int[n+1][3];
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = i;
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][2] = Integer.MAX_VALUE;
        }
        dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][2] = Math.min(dp[i][2], Math.max(1 + dp[i - j][2], 1 + dp[j - 1][1]));
            }
        }
        return dp[n][2];
    }

}
