package com.monster.learn;

import java.util.Stack;

//76.12%
public class ValidateStackSequences {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    if (pushed.length != popped.length) {
      return false;
    }
    if (pushed.length == 0) {
      return true;
    }
    Stack<Integer> stack = new Stack<>();
    int idxPush = 0;
    int idxPop = 0;
    for (; idxPop < pushed.length; idxPop++) {
      if (stack.isEmpty()) {
        stack.push(pushed[idxPush++]);
      }
      while(stack.peek() != popped[idxPop]) {
        if (idxPush >= pushed.length) {
          return false;
        } else {
          stack.push(pushed[idxPush++]);
        }
      }
      stack.pop();
    }
    return stack.isEmpty();
  }
}