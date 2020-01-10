package com.monster.learn;

//85.31%
public class NextGreaterElements {
  public int[] nextGreaterElements(int[] nums) {
    int[] ret = new int[nums.length];
    for (int i = 0; i < ret.length; i++) {
      int cur = nums[i];
      boolean has = false;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] > cur) {
          ret[i] = nums[j];
          has = true;
          break;
        }
      }
      if (!has) {
        for (int j = 0; j < i; j++) {
          if (nums[j] > cur) {
            ret[i] = nums[j];
            has = true;
            break;
          }
        }
        if (!has) {
          ret[i] = -1;
        }
      }
    }
    return ret;
  }
}