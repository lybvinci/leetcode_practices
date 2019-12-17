package com.monster.learn;

//99.80%
public class FindMaxForm {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m+1][n+1];
    for (int i = 0; i < strs.length; i++) {
      int useM = 0;
      int useN = 0;
      for (int j = 0; j < strs[i].length(); j++) {
        if (strs[i].charAt(j) == '0') {
          useM++;
        } else {
          useN++;
        }
      }
      for (int j = m; j >= useM; j--) {
        for (int k = n; k >= useN; k--) {
          dp[j][k] = Math.max(dp[j][k], dp[j-useM][k-useN] + 1);
        }
      }
    }
    return dp[m][n];
  }
}