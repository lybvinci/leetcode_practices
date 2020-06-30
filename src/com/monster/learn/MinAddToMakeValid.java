package com.monster.learn;

import java.util.Stack;

//65.05%
public class MinAddToMakeValid {

  public int minAddToMakeValid(String S) {
    Stack<Character> stack = new Stack<>();
    int ret = 0;
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          ret++;
        } else {
          stack.pop();
        }
      }
    }
    return ret + stack.size();
  } 
}