package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//65.79%
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int mx = 0;
        int mxIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                        if (mx < dp[i]) {
                            mx = dp[i];
                            mxIdx = i;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < mx; i++) {
            result.add(nums[mxIdx]);
            mxIdx = parent[mxIdx];
        }
        return result;
    }
}