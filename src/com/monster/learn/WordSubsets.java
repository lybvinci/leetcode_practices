package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//93.82%
public class WordSubsets {
  public List<String> wordSubsets(String[] A, String[] B) {
    List<String> ret = new ArrayList<>();
    int[] charCnt = new int[26];
    for (String s : B) {
      int[] t = helper(s);
      for (int i = 0; i < 26; i++) {
        charCnt[i] = Math.max(charCnt[i], t[i]);
      }
    }
    for (String s : A) {
      int[] t = helper(s);
      int i = 0;
      for (; i < 26; i++) {
        if (t[i] < charCnt[i]) {
          break;
        }
        
      }
      if (i == 26) {
        ret.add(s);
      }
    }
    return ret;
  }

  private int[] helper(String s) {
    int[] charCnt = new int[26];
    for (int i = 0; i < s.length(); i++) {
      charCnt[s.charAt(i) - 'a']++;
    }
    return charCnt;
  }

  public static void main(String[] args) {
    WordSubsets ws = new WordSubsets();
    ws.wordSubsets(new String[]{"apple", "facebook"}, new String[]{"e", "o"});
  }
  
}