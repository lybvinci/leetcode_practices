package com.monster.learn;

//86.28%
public class MinFallingPathSum {
  public int minFallingPathSum(int[][] A) {
    if (A.length == 0 || A[0].length == 0) {
      return 0;
    }
    int[][] res = new int[A.length][A[0].length];
    for (int i = 0; i < A[0].length; i++) {
      res[0][i] =  A[0][i];
    }
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (j == 0) {
          res[i][j] = Math.min(res[i-1][j], res[i-1][j+1]) + A[i][j];
        } else if (j == A[0].length - 1) {
          res[i][j] = Math.min(res[i-1][j-1], res[i-1][j]) + A[i][j];
        } else {
          res[i][j] = Math.min(Math.min(res[i-1][j-1], res[i-1][j]), res[i-1][j+1]) + A[i][j];
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < A[0].length; i++) {
      if (res[res.length - 1][i] < min) {
        min = res[res.length - 1][i];
      }
    }
    return min;



























    // int[][] res = new int[A.length][A[0].length];

    // for (int i = 0; i < A[0].length; i++) {
    //   res[0][i] = A[0][i];
    // }
    // for (int i = 1; i < A.length; i++) {
    //   for (int j = 0; j < A[i].length; j++) {
    //     if (j == 0) {
    //       res[i][j] = Math.min(res[i-1][j+1], res[i-1][j]) + A[i][j];
    //     } else if (j == A[i].length - 1) {
    //       res[i][j] = Math.min(res[i-1][j-1], res[i-1][j]) + A[i][j];
    //     } else {
    //       res[i][j] = Math.min(Math.min(res[i-1][j+1], res[i-1][j-1]), res[i-1][j]) + A[i][j];
    //     }
    //   }
    // }
    // int min = Integer.MAX_VALUE;
    // for (int i = 0; i < res[res.length - 1].length; i++) {
    //   if (res[res.length - 1][i] < min) {
    //     min = res[res.length - 1][i];
    //   }
    // }
    // return min;

  }
}