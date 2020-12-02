package com.monster.learn;

import java.util.Arrays;

//9.72%
public class LargestSumAfterKNegations {

  public int largestSumAfterKNegations(int[] A, int K) {
    for (int i = 0; i < K; i++) {
      Arrays.sort(A);
      A[0] = -A[0];
    }
    int sum = 0;
    for (int i =0; i < A.length; i++) {
      sum += A[i];
    }
    return sum;
  }
}
