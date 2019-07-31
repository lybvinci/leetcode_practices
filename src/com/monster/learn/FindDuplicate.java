package com.monster.learn;

//66.44%
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int[] dup = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dup[nums[i]]++;
            if (dup[nums[i]] == 2) {
                return nums[i];
            }
        }
        return -1;
    }
}