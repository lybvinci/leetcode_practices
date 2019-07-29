package com.monster.learn;

import java.util.Arrays;

//7.89%
public class NumSquares {

    public static void main(String[] args) {
        NumSquares ns = new NumSquares();
        int res = ns.numSquares(12);
        System.out.println(res);
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int sqr = (int) Math.sqrt(i);
            if (sqr * sqr == i) dp[i] = 1;
            else {
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.min(dp[j] + dp[i-j], dp[i]);
                }
            }
        }
        return dp[n];
    }
}