package com.monster.learn;

//15.68%
public class LongestPalindromeSubseq {
  public int longestPalindromeSubseq(String s) {
    int[][] dp = new int[1001][1001];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
    }
    for (int j = 1; j < s.length(); j++) {
      for (int i = j -1; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i+1][j-1]+2;
        } else {
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }
    return dp[0][s.length() - 1];
  }
}