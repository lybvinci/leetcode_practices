package com.monster.learn;

import java.util.Arrays;
import java.util.Comparator;

//88.15%
public class FindMinArrowShots {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] lhs, int[] rhs) {
        return lhs[0] - rhs[0];
      }
    });
    int end = points[0][1], res = 0;
    for (int i = 0; i < points.length; i++) {
      if (points[i][0] > end) {
        res++;
        end = points[i][1];
      } else {
        end = Math.min(points[i][1], end);
      }
    }
    return ++res;
  }
}