package com.monster.learn;

public class FindPeakElement162 {
    //94.57% 
    public int findPeakElement(int[] nums) {
        long pre = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pre) {
                return i - 1;
            }
            pre = nums[i];
        }
        return nums.length - 1;
    }
}