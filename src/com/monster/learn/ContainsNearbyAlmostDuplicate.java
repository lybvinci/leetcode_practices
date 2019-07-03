package com.monster.learn;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// 55.49%
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // too slow
        /*
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && j - i <= k; j++ ) {
                int cha = Math.abs(nums[i] - nums[j]);
                if (cha <= t) {
                    return true;
                }
            }
        }
        return false;
        */
        if (k < 1 || t < 0)
            return false;
        SortedSet<Long> ss = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> son = ss.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!son.isEmpty()) {
                return true;
            }
            if (i >= k) {
                ss.remove((long)(nums[i - k]));
            }
            ss.add((long)nums[i]);
        }
        return false;
    }
}