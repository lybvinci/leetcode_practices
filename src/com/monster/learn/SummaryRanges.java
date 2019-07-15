package com.monster.learn;

import java.util.LinkedList;
import java.util.List;

//100.00%
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int current = nums[i];
            int end = start;
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] != current + 1) {
                    break;
                } else {
                    current = nums[j];
                    end = nums[j];
                }
            }
            String s = null;
            if (start != end) {
                s = start + "->" + end;
                i = j - 1;
            } else {
                s = start + "";
            }
            res.add(s);
        }
        return res;
    }
}