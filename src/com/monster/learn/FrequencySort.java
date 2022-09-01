package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//73.51%
public class FrequencySort {
  public String frequencySort(String s) {
    if (null == s || s.length() < 1) {
      return s;
    }
    HashMap<Character, Integer> map = new HashMap<>();    
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
    }
    List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o2.getValue() - o1.getValue();
      }
    });
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Character, Integer> t: list) {
      for (int i = 0; i < t.getValue(); i++) {
        sb.append(t.getKey());
      }
    }
    return sb.toString();
  }

  //1636
  //47.89%
  public int[] frequencySort(int[] nums) {
    Integer[] numsInteger = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numsInteger[i] = nums[i];
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
    }
    Arrays.sort(numsInteger, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        int e = map.get(o1).compareTo(map.get(o2));
        return e == 0 ? o2.compareTo(o1) : e;
      }
    });
    int[] ret = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ret[i] = numsInteger[i];
    }
    return ret;
  }
}