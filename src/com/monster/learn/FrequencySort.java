package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
}