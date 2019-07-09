package com.monster.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//20.95%
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(nums[i], 0);
            num += 1;
            if (num == nums.length / 3 + 1) {
                res.add(nums[i]);
            }
            if (res.size() >= 2) {
                return res;
            }
            map.put(nums[i], num);
        }
        return res;
    }
}