package com.monster.learn;

import java.util.ArrayList;

//14.99%
public class FindJudge {

  public int findJudge(int N, int[][] trust) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      boolean maybeJudge = true;
      for (int j = 0; j < trust.length; j++) {
        if (trust[j][0] == i) {
          maybeJudge = false;
          break;
        }
      }
      if (maybeJudge) {
        al.add(i);
      }
    }
    if (al.size() <= 0) {
      return -1;
    }
    for (int i : al) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < trust.length; j++) {
        list.add(trust[j][1]);
      }
      int count = (int)list.stream().filter((p) -> { return p == i;}).count();
      if (count == N - 1) {
        return i;
      }
    }
    return -1;
  }
  
}