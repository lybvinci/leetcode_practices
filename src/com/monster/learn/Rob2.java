package com.monster.learn;

// 98.55%
public class Rob2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robDP(nums, 0, nums.length - 2), robDP(nums, 1, nums.length - 1));
    }

    public int robDP(int[] nums, int first, int last) {
        int n = last - first + 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[first];
        }
        int[] dp = new int[n];
        dp[0] = nums[first];
        dp[1] = Math.max(nums[first], nums[first+1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[first+i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}