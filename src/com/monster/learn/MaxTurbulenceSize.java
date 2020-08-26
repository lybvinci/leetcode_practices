package com.monster.learn;

// 98.3%
public class MaxTurbulenceSize {

  public int maxTurbulenceSize(int[] A) {
    int len = A.length;
    if (len < 2) {
      return len;
    }
    int res = 2;
    int flag = A[0] - A[1];
    if (flag == 0) {
      res = 1;
    }
    int temp = res;
    for (int i = 1; i < len - 1; i++) {
      int p = A[i] - A[i + 1];
      if (flag > 0 && p < 0 || flag < 0 && p > 0) {
        temp++;
      } else {
        res = Math.max(res, temp);
        if (p == 0) {
          temp = 1;
        } else {
          temp = 2;
        }
      }
      flag = p;
    }
    return Math.max(res, temp);
  }

  public static void main(String[] args) {
    MaxTurbulenceSize mt = new MaxTurbulenceSize();
    mt.maxTurbulenceSize(new int[]{0,1,1,0,1,0,1,1,0,0});
  }
  
}