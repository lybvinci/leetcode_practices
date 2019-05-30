package com.monster.learn;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = nums[i];
            int tempProduct = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                tempProduct *= nums[j];
                if (tempProduct >= tempMax) {
                    tempMax = tempProduct;
                }
            }
            maxSum = Math.max(maxSum, tempMax);
        }
        return maxSum;    
    }
}