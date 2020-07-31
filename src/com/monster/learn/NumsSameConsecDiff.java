package com.monster.learn;

import java.util.ArrayList;

//43.68%
public class NumsSameConsecDiff {
  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0,1,2,3,4,5,6,7,8,9};
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      dfs(i, N, K, list);
    }
    return list.stream().mapToInt(i -> i).toArray();
  } 

  private void dfs(int num, int N, int K, ArrayList<Integer> list) {
    if ((int)(Math.log10(num)) + 1 == N) {
      list.add(num);
      return;
    }
    int pre = num % 10;
    if (pre >= K) {
      dfs(10*num+pre-K, N, K, list);
    }
    if (K!=0 && pre + K <= 9) {
      dfs(10*num+pre+K, N, K, list);
    }

  }
}