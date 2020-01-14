package com.monster.learn;

import java.util.HashSet;
import java.util.Set;

//17.21%
public class CheckPerfectNumber {
  public boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }
    Set<Integer> c = new HashSet<>();
    c.add(1);
    for (int i = 2; i < num / 2 + 1; i++) {
      if (num % i == 0) {
        c.add(i);
        c.add(num/i);
      }
    }
    int sum = 0;
    for (int i : c) {
      sum += i;
    }
    return num == sum;
  }
}