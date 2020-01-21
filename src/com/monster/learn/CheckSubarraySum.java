package com.monster.learn;

// 22.39%
public class CheckSubarraySum {
  public boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    if (nums.length < 2) {
      return false;
    }
    for (int i = 0; i < nums.length; i++) {
      sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (k == 0 && sum == 0) {
          return true;
        } else if (k != 0 && (sum == 0 || sum % k == 0)) {
          return true;
        }
      }
    }
    return false;
  }
}