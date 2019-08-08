package com.monster.learn;

// 23.80%
public class NumArray {
    private int[] num;
    public NumArray(int[] nums) {
        num = new int[nums.length + 1];
        num[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            num[i+1] = nums[i] + num[i];
        }
    }
    
    public void update(int i, int val) {
        int den = val - (num[i+1] - num[i]);
        for (i++; i < num.length; i++) {
            num[i] += den;
        }
    }
    
    public int sumRange(int i, int j) {
        return num[j+1] - num[i];
    }
}