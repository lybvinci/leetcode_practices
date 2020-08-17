package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//5.04%
public class IntervalINtersection {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> ans = new ArrayList<>();
    for (int[] a : A) {
      for (int[] b : B) {
        if (a[a.length - 1] < b[0] || b[b.length - 1] < a[0]) {
          continue;
        }
        int[] intersection = new int[2];
        intersection[0] = Math.max(a[0], b[0]);
        intersection[1] = Math.min(a[a.length - 1], b[b.length - 1]);
        ans.add(intersection);
      }
    } 
    return ans.toArray(new int[ans.size()][2]);
  } 
}