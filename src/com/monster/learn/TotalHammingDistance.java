package com.monster.learn;

//40.29%
public class TotalHammingDistance {
  public int totalHammingDistance(int[] nums) {
    int cnt, ans = 0;
    for (int i = 0; i < 32; i++) {
      cnt = 0;
      for (int j = 0; j < nums.length; j++) {
        if ((nums[j] & 1) == 1) {
          cnt++;
        }
        nums[j] >>= 1;
      }
      ans += cnt * (nums.length - cnt);
    }
    return ans;
  }
}