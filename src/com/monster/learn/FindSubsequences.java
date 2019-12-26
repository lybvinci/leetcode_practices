package com.monster.learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//35.44%
public class FindSubsequences {

  public static void main(String[] args) {
    FindSubsequences fs = new FindSubsequences();
    fs.findSubsequences(new int[]{4,6,7,7});
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    helper(result, new LinkedList<>(), nums, 0);
    return new ArrayList<List<Integer>>(result);
  }

  private void helper(Set<List<Integer>> result, LinkedList<Integer> item, int[] nums, int start) {
    if (item.size() > 1) {
      result.add(new LinkedList<>(item));
    }
    for (int i = start; i < nums.length; i++) {
      if (!item.isEmpty() && nums[i] < item.getLast()) {
        continue;
      } else {
        item.add(nums[i]);
        helper(result, item, nums, i+1);
        item.removeLast();
      }
    }
  }

}