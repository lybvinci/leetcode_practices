package com.monster.learn;

public class MinSubArrayLen {
    public static void main(String[] args) {
        minSubArrayLen(8, new int[]{2,3,1,2,4,3});
    }
    //93.92%
    public static int minSubArrayLen(int s, int[] nums) {
        // too slow
        /*
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j + i >= nums.length) {
                    break;
                }
                int sum = 0;
                for (int k = 0; k <= i; k++) {
                    sum += nums[j + k];
                }
                if (sum >= s) {
                    return i + 1;
                }
            }
        }    
        return 0;
        */
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}