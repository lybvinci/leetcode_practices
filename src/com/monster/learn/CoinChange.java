package com.monster.learn;

import java.util.Arrays;

//81.97%
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        /*
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 999999;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] +1, dp[i]);
                }
            }
        }
        return dp[amount] == 999999 ? -1 : dp[amount];
        */
    }

    //dp[0] = 0;
    // dp[1] = 1;
    // dp[2] = min(dp[2],1+dp[i-coin]) ? 
    //23.38%
    public int coinChange2(int[] coins, int amount) {
      int[] dp = new int[amount+1];
      for (int i = 0; i < dp.length; i++) {
        dp[i] = amount + 1;
      }
      dp[0] = 0;
      for (int i = 0; i <= amount; i++) {
        for (int coin : coins) {
          if (i - coin < 0) {
            continue;
          }
          dp[i] = Math.min(dp[i], dp[i-coin] + 1);
        }
      }
      return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}