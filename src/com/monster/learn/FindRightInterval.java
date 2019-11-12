package com.monster.learn;

import java.util.TreeMap;

//50.82%
public class FindRightInterval {
  public int[] findRightInterval(int[][] intervals) {
    if (intervals.length < 1) {
      return new int[0];
    } else if (intervals.length < 2) {
      return new int[]{-1};
    }
    int[] ret = new int[intervals.length];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i][0], i);
    }
    for (int i = 0; i < intervals.length; i++) {
      Integer maybe = map.ceilingKey(intervals[i][1]);
      if (null == maybe) {
        ret[i] = -1;
      } else {
        ret[i] = map.get(maybe);
      }
    }

    return ret;
  }
}