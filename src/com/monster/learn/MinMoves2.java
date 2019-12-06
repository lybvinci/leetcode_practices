package com.com.monster.learn;

import java.util.Arrays;

//98.91%
public class MinMoves2 {
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      sum += nums[j] - nums[i];
      j--;
      i++;
    }
    return sum;
  }
}