package com.monster.learn;

//15.03%
public class FindMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                ret = Math.max(ret, nums[i] ^ nums[j]);
            }
        }
        return ret;
    }
}