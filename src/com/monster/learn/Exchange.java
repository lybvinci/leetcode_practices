package com.monster.learn;

public class Exchange {

	//47.96%
	public int[] exchange(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] % 2 == 0) {
				while (right >= 0 && nums[right] % 2 == 0) {
					right--;
				}
				if (left < right && right >= 0) {
					int numLeft = nums[left];
					nums[left] = nums[right];
					nums[right] = numLeft;
					right--;
				}
			}
			left++;
		}
		return nums;
	}	

	public static void main(String[] args) {
		Exchange e = new Exchange();
		e.exchange(new int[]{8,10,3,20,12,4,10,8,4,0,5,17,7,20,3});
	}

}
