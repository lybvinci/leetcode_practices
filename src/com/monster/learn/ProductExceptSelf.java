package com.monster.learn;

//98.38%
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i - 1];
            res[i] = mul;
        }
        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul *= nums[i+1];
            res[i] *= mul;
        }
        return res;
    }
}