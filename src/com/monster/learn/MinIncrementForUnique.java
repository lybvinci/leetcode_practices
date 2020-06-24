package com.monster.learn;

import java.util.Arrays;

//41.32%
public class MinIncrementForUnique {

  public int minIncrementForUnique(int[] A) {
    Arrays.sort(A);
    int step = 0;
    int res = 0;
    for (int i = 0; i < A.length; i++) {
      res += Math.max(step, A[i]) - A[i];
      step = Math.max(step, A[i]) + 1;
    }
    return res;
  }
}