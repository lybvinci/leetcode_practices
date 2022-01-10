package com.monster.learn;

public class SubarraysDivByK {

	//94.52%
	public int subarraysDivByK(int[] nums, int k) {
      // 计算第一个的余数
      nums[0] = nums[0] % k;
      // 统计前缀和的余数
      for (int i = 1;i < nums.length;i++) nums[i] = (nums[i-1] + nums[i]) % k;
      // 统计余数相同的个数
      int[] count = new int[k];
      count[0]++;
      for (int x : nums) count[(x % k + k) % k]++;
      // 计算一共有多少个
      int ans = 0;
      for (int y : count) ans = ans + y * (y - 1) / 2;
      return ans;
	}	
}
