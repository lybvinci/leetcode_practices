package com.monster.learn;

import java.util.Arrays;

//95.37%
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int start = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start) {
                continue;
            }
            if (nums[i] != ++start) {
                max = Math.max(max, count);
                count = 1;
                start = nums[i];
            } else {
                count++;
            }
        }
        return Math.max(max, count);
    }
    
}
