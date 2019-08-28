package com.monster.learn;

//5.22%
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int k = 0; k < nums.length - 2; k++) {
            int first = nums[k];
            for (int i = k + 1; i < nums.length - 1; i++) {
                int second = nums[i];
                if (second > first) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > second) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}