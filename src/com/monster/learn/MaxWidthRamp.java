package com.monster.learn;

//16.77%
public class MaxWidthRamp {
  public int maxWidthRamp(int[] A) {
    int ret = 0;
    int i = 0;
    int j = 0;
    for (int k = 0; k < A.length; k++) {
      if (ret >= (A.length - 1 - k)) {
        break;
      }
      i = k;
      for (int l = A.length - 1; l >= i; l--) {
        if (A[i] <= A[l]) {
          j = l;
          break;
        }
      }
      ret = Math.max(ret, j - i);
    }
    return ret;
  } 
}