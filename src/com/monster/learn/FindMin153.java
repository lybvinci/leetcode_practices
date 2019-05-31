package com.monster.learn;

public class FindMin153 {
    //96.14% 
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                return nums[i];
            }
        }
        return nums[0];
    }
}