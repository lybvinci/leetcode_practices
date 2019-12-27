package com.monster.learn;

//5.60%
public class FindTargetSumWays {

  public static void main(String[] args) {
    FindTargetSumWays ft = new FindTargetSumWays();
    ft.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
  }


  private int res = 0;
  public int findTargetSumWays(int[] nums, int S) {
    res = 0;
    helper(nums, S, 0, 0);
    return res;
  }

  private void helper(int[] nums, int S, int start, int tempSum) {
    if (start >= nums.length) {
      if (tempSum == S) {
        res++;
        return;
      }
      return;
    }
    helper(nums, S, start+1, tempSum + nums[start]);
    helper(nums, S, start+1, tempSum - nums[start]);
  }
}