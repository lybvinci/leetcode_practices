package com.monster.learn;

import java.util.HashMap;

//5.29%
public class ThreeSumMulti {
  private static final int mod = 1000000007; 
  public int threeSumMulti(int[] A, int target) {
    long ret = 0;
    HashMap<Integer, Long> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      ret = (ret + map.getOrDefault(target - A[i], 0L)) % mod;
      for (int j = 0; j < i; j++) {
        map.put(A[i] + A[j], map.getOrDefault(A[i]+A[j], 0L) + 1);
      }
    } 
    return (int)(ret % mod);
  } 
}