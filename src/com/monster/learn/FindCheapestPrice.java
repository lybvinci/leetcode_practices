package com.monster.learn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindCheapestPrice {

    //f(x) =  x=0 => for (i : flights) price = min(price, [src,dst])
    // x=1 => for (i : flights) price = min(price, [src, tmp, dst])
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] memo = new int[n][k + 2];
        return helper(flights, src, dst, k, memo);
    } 

    private int helper(int[][] flights, int src, int dst, int k, int[][] memo) {
        if (k < 0) {
            return -1;
        }
        if (src == dst) {
            return 0;
        }
        if (memo[src][k] != 0) {
            return memo[src][k];
        }
        int ret = Integer.MAX_VALUE;
        if (k == 0) {
            for (int i = 0; i < flights.length; i++) {
                if (flights[i][0] == src && flights[i][1] == dst) {
                    ret = Math.min(ret, flights[i][2]);
                } else if (src == dst) {
                    ret = 0;
                }
            }
        } else {
            for (int i = 0; i < flights.length; i++) {
                if (flights[i][0] == src) {
                    int last = helper(flights, flights[i][1], dst, k - 1, memo);
                    if (last != -1) {
                        ret = Math.min(ret, last + flights[i][2]);
                    }
                }
            }
        }
        if (ret != Integer.MAX_VALUE) {
            memo[src][k] = ret;
            return ret;
        } else {
            return -1;
        }
    }

    //65.54%
    private static final int INF = 1000007;

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                dp[flight[0]][i] = Math.min(dp[flight[0]][i], dp[flight[1]][i - 1] + flight[2]);
            }
        } 
        int ans = IntStream.of(dp[src]).min().getAsInt();
        return ans >= INF ? -1 : ans;
    } 



    public static void main(String[] args) {
        FindCheapestPrice fcp = new FindCheapestPrice();
        int ret = fcp.findCheapestPrice(3, new int[][]{{0,1,2},{1,2,1}, {2,0,10}}, 1, 2, 1);
        System.out.print(ret);
    }

}
