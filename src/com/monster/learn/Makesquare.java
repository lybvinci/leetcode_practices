package com.monster.learn;

//18.67%
public class Makesquare {
  public boolean makesquare(int[] nums) {
   long sum = 0;
   for (int i = 0; i < nums.length; i++) {
     sum += nums[i];
   }     
   if (sum % 4 != 0 || sum < 4) {
    return false;
   }
   int bianchang = (int)sum / 4;
   int[] res = new int[4];
   return helper(nums, res, 0, bianchang);
  }

  public boolean helper(int[] nums, int[] res, int pos, int target) {
    if (pos >= nums.length) {
      return res[0] == target && res[1] == target && res[2] == target && res[3] == target;
    }
    for (int i = 0; i < res.length; i++) {
      if (res[i] + nums[pos] > target) continue;
      res[i] += nums[pos];
      if (helper(nums, res, pos + 1, target)) return true;
      res[i] -= nums[pos];
    }
    return false;
  }
}