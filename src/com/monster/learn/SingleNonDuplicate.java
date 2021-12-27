package com.monster.learn;

//12.92%
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                last = nums[i];
            } else {
                if (last != nums[i]) {
                    return last;
                }
            }
        }
        return nums[nums.length - 1];
    } 
}
