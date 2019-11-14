package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//98.41%
public class FindDuplicates {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ret = new ArrayList<>();
    if (nums == null || nums.length < 2) {
      return ret;
    }
    int[] tmp = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      tmp[nums[i]]++;
      if (tmp[nums[i]] == 2) {
        ret.add(nums[i]);
      }
    }
    return ret;
  }
}