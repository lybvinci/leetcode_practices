package com.monster.learn;

import java.util.HashMap;

public class MinSubarray {

	public int minSubarray(int[] nums, int p) {
		// long sum = 0;
		// for (int i = 0; i < nums.length; i++) {
		// 	sum += nums[i];
		// }
		// if (sum % p == 0) {
		// 	return 0;
		// }
		// if (nums.length == 1) {
		// 	return -1;
		// }
		// int count = Integer.MAX_VALUE;
		/*
		 * too slow
		for (int i = 0; i < nums.length; i++) {
			long temp = sum;
			int tempCount = 0;
			for (int j = i; j < nums.length; j++) {
				if (i == 0 && j == nums.length - 1) {
					break;
				}
				temp -= nums[j];
				tempCount++;
				if (temp % p == 0) {
					count = Math.min(count, tempCount);
					break;
				}
			}
		}
		*/
    /* slow too
		int curCount = 1;
		while (curCount < nums.length) {
			for (int i = 0; i < nums.length; i++) {
				long temp = sum;
				if (i + curCount > nums.length) {
					break;
				}
				for (int j = 0; j < curCount; j++) {
					temp -= nums[i+j];
				}
				if (temp % p == 0) {
					return curCount;
				}
			}
			curCount++;
		}
		*/
		

		// return count == Integer.MAX_VALUE ? -1 : count;

		//34.93%
		int ans = Integer.MAX_VALUE;
		HashMap<Long , Integer> map = new HashMap<>();
		//用 mod 存储 和 的余数
		long mod = 0;
		for(int num: nums){
				mod += num;
		}
		mod = mod % p;
		if(mod == 0){ 
				return 0; //如果 余数 为零，就说明整个数组的和是能被整除的！ 
		} 
		long sum = 0;       //sum存储的是 nums[0] 到 nums[i]的和，也就是前缀和
		map.put((long)0,-1);//把 0 设置为 -1，因为数组起始坐标为0！
		for(int i = 0;i < nums.length;i ++){
				sum += nums[i];
				long counter = sum % p;//求出 前缀和 对 p 取余!
				long aimnum  =  (counter -  mod + p) % p; //求出目标的前缀和
				if(map.get(aimnum) != null){
						ans = Math.min(ans,i - map.get(aimnum));
				}
				map.put(counter,i);//将当前位置的前缀和存储map中！
		}
		return ans >= nums.length ? -1 : ans;

	}	

	public static void main(String[] args) {
		MinSubarray	ms = new MinSubarray();
		ms.minSubarray(new int[]{6,3,5,2}, 9);
	}

}
