package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PancakeSort {
  public List<Integer> pancakeSort(int[] A) {
    int[] sortedA = Arrays.copyOf(A, A.length);
    Arrays.sort(sortedA);
    List<Integer> res = new ArrayList<>();
    for (int i = A.length - 1; i > 0; i--) {
      if (A[i] != sortedA[i]) {
        int j = 0;
        for (; j < A.length; j++) {
          if (A[j] == sortedA[i]) {
            break;
          }
        }
        A = reverse(A, j);
        A = reverse(A, i);
        res.add(j+1);
        res.add(i+1);
      }
    }
    return res;
  }

  private int[] reverse(int[] origin, int start) {
    int[] res = new int[origin.length];
    for (int i = start + 1; i < res.length; i++) {
      res[i] = origin[i];
    }
    for (int i = 0; i <= start; i++) {
      res[i] = origin[start - i];
    }
    return res;
  }

  public static void main(String[] args) {
    PancakeSort ps = new PancakeSort();
    ps.pancakeSort(new int[]{3,2,4,1});
  }
}
