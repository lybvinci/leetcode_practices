package com.monster.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//18.55%
public class MinDeletionSize {

  Set<Integer> st;

  public int minDeletionSize(String[] A) {

    int ans = 0;
    int n = A.length;
    int m = A[0].length();
    st = new HashSet<>();

    String[] a = new String[n];

    for (int j = 0; j < m; j++) {
      String[] b = Arrays.copyOf(a, n);
      for (int i = 0; i < n; i++) {
        b[i] += A[i].charAt(j);
      }
      if (check(b))
        a = b;
      else
        ans++;
    }

    return ans;

  }

  private boolean check(String[] a) {

    for (int i = 0; i < a.length - 1; i++)
      if (a[i].compareTo(a[i + 1]) > 0)
        return false;
    return true;

  }

  public static void main(String[] args) {
    MinDeletionSize mds = new MinDeletionSize();
    mds.minDeletionSize(new String[]{"xga","xfb","yfa"});
  }

}
