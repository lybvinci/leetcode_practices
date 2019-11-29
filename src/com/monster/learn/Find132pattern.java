package com.monster.learn;

//27.21%
public class Find132pattern {
  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int mn = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      mn = Math.min(mn, nums[i]);
      if (mn == nums[i]) continue;
      for (int k = nums.length - 1; k > i; k--) {
        if (mn < nums[k] && nums[i] > nums[k]) return true;
      }
    }
    return false;
  }
}