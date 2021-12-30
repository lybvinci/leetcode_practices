package com.monster.learn;

//100.00%
public class Check1572 {

    public boolean check(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int smallerCount = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                if (smallerCount > 0) {
                    return false;
                }
                smallerCount++;
            }
            pre = nums[i];
        }
        if (smallerCount > 0) {
            return nums[0] >= nums[nums.length - 1];
        }
        return true;
    } 

    public static void main(String[] args) {
        Check1572 c = new Check1572();
        c.check(new int[]{6,4,7,1,3});
    }

}
