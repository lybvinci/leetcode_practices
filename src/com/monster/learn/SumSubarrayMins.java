package com.monster.learn;

import java.util.Stack;

//30.75%
public class SumSubarrayMins {
  private static final int MOD = (int)Math.pow(10, 9) + 7;
  public int sumSubarrayMins(int[] A) {
    int n = A.length;
    int[] sum = new int[n];
    Stack<Integer> sp = new Stack<>();
    for (int i = 0; i < n; i++) {
      while(!sp.empty() && A[sp.peek()] >= A[i]) {
        sp.pop();
      }
      sum[i] = sp.empty() ? (i+1) * A[i] : (i - sp.peek()) *A[i] + sum[sp.peek()];
      sum[i] %= MOD;
      sp.push(i);
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      res += sum[i];
      res %= MOD;
    }
    return res;
  }
  
}