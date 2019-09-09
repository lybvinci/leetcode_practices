package com.monster.learn;
//84.17%
public class WiggleMaxLength {
    private static final int BEGIN = 0;
    private static final int UP = 1;
    private static final int DOWN = 2;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int stat = BEGIN;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            switch(stat) {
                case BEGIN:
                    if (nums[i - 1] < nums[i]) {
                        stat = UP;
                        res++;
                    } else if (nums[i - 1] > nums[i]) {
                        stat = DOWN;
                        res++;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > nums[i]) {
                        stat = DOWN;
                        res++;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1] < nums[i]) {
                        stat = UP;
                        res++;
                    }
                    break;
            }
        }
        return res;

    }
}