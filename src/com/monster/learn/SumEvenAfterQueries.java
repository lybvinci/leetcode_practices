package com.monster.learn;

public class SumEvenAfterQueries {

  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    if (A == null || queries == null) {
      return null;
    }
    int lastSum = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        lastSum += A[i];
      }
    }
    int[] answers = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      if ((A[queries[i][1]] + queries[i][0]) % 2 == 0) {
        if (A[queries[i][1]] % 2 == 0) {
          lastSum += queries[i][0];
        } else {
          lastSum += A[queries[i][1]] + queries[i][0];
        }
      } else {
        if (A[queries[i][1]] % 2 == 0) {
          lastSum -= A[queries[i][1]];
        }
      }
      A[queries[i][1]] += queries[i][0];
      answers[i] = lastSum;
    }
    return answers;
  }

  public static void main(String[] args) {
    SumEvenAfterQueries saq = new SumEvenAfterQueries();
    saq.sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0}, {-3, 1}, {-4, 0}, {2, 3}});
  }
  
}