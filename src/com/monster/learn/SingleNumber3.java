package com.monster.learn;

import java.util.HashSet;
import java.util.Set;

//13.08%
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] ret = new int[2];
        int i = 0;
        for (Integer ii : set) {
            ret[i++] = ii;
        }
        return ret;
    }
}