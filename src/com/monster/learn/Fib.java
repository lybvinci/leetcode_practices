package com.monster.learn;

//20.46%
public class Fib {
  public int fib(int N) {
    if (N == 0) {
      return 0;
    }
    if (N == 1) {
      return 1;
    }
    return fib(N - 1) + fib(N - 2);
  }

  //100%
  public int fib2(int N) {
    if (N == 0) {
      return 0;
    }
    if (N == 1) {
      return 1;
    }
    int pre = 0;
    int cur = 1;
    int temp = pre + cur;
    for (int i = 2; i <= N; i++) {
      temp = pre + cur;
      pre = cur;
      cur = temp;
    }
    return cur;
  }
}