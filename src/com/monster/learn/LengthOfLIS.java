package com.monster.learn;

//53.12%
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lolis = new LengthOfLIS();
        int res = lolis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max < dp[j])
                    max = dp[j];
            }
            dp[i] = max + 1;
            if (result < dp[i])
                result = dp[i];
        }
        return result;
    }
}