package com.monster.learn;

// 95.07%
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int dp1[] = new int[prices.length];
        int dp2[] = new int[prices.length];
        dp2[0] = -prices[0];
        for(int i=1;i<prices.length;++i){
            dp1[i]=Math.max(dp1[i-1],dp2[i-1]+prices[i]);
            dp2[i]=Math.max(dp2[i-1],-prices[i]+(i>=2?dp1[i-2]:0));
        }
        return Math.max(dp1[prices.length-1],dp2[prices.length-1]);
    }
}