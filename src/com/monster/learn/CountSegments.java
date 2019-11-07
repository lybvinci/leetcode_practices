package com.monster.learn;

//100.00%
public class CountSegments {
  public int countSegments(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int ret = 0;
    char[] chars = s.toCharArray();
    boolean hasStart = false;
    for (char c : chars) {
      if (c == ' ') {
        if (hasStart) {
          ret++;
          hasStart = false;
        } else {
          continue;
        }
      } else {
        if (hasStart) {
          continue;
        } else {
          hasStart = true;
        }
      }
    }      
    if (hasStart) {
      ret++;
    }
    return ret;
  }
}