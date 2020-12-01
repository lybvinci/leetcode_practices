package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//30.97%
public class CommonChars {
  public List<String> commonChars(String[] A) {
    int[][] cc = new int[A.length][26];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length(); j++) {
        cc[i][A[i].charAt(j) - 'a'] += 1;
      }
    }
    List<String> ret = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < cc.length; j++) {
        min = Math.min(min, cc[j][i]);
      }
      for (int k = 0; k < min; k++) {
        ret.add("" + (char)('a' + i));
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    CommonChars cc = new CommonChars();
    cc.commonChars(new String[]{"bella","label","roller"});
  }
}
