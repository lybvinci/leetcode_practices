package com.monster.learn;

import java.util.Arrays;

public class FindKthLargest {
    //75.27%
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }
}