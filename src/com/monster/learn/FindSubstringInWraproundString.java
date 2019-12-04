package com.monster.learn;

//96.30%
public class FindSubstringInWraproundString {
  public int findSubstringInWraproundString(String p) {
    int[] p_int =  new int[p.length()];
    int[] count = new int[26];
    for (int i = 0; i < p.length(); i++) {
      p_int[i] = p.charAt(i) - 'a';
    }
    int res = 0;
    int maxLen = 0;
    for (int i = 0; i < p.length(); i++) {
      if (i > 0 && (p_int[i - 1] + 1) % 26 == p_int[i]) {
        maxLen++;
      } else {
        maxLen = 1;
      }
      count[p_int[i]] = Math.max(count[p_int[i]], maxLen);
    }
    for (int i = 0; i < 26; i++) res+= count[i];
    return res;
  }
}