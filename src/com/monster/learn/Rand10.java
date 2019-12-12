package com.monster.learn;

public class Rand10 {
  public int rand10() {
    while(true) {
      int num = (rand7() - 1) * 7 + rand7();
      if (num <= 40) return num % 10 + 1;
    }
  }

  public int rand7() {
    return 0;
  }
}