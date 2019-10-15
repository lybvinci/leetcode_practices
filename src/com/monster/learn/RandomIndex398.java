package com.monster.learn;

import java.util.Arrays;
import java.util.Random;

//84.53%
public class RandomIndex398 {
    private int[] origin;
    private Random ran;
    public RandomIndex398(int[] nums) {
        origin = nums;
        ran = new Random();
    }
    
    public int pick(int target) {
        int res = 0;
        int number = 0;
        int length = origin.length;
        for (int i = 0; i < length; i++) {
            if (origin[i] == target) {
                number++;
                if (ran.nextInt(number) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}