package com.monster.learn;

public class MinCount {

    //100.00%
    public int minCount(int[] coins) {
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += coins[i] / 2 + coins[i] % 2;
        }
        return ans;
    } 

}
