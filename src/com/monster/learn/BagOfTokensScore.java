package com.monster.learn;

import java.util.Arrays;

//87.35%
public class BagOfTokensScore {
  public int bagOfTokensScore(int[] tokens, int P) {
    Arrays.sort(tokens);
    int ret = 0;
    int point = 0;
    int start = 0;
    int end = tokens.length - 1;
    while (start <= end) {
      if (P >= tokens[start]) {
        P -= tokens[start++];
        ret = Math.max(ret, ++point);
      } else {
        if (ret > 0) {
          P += tokens[end--];
          point--;
        } else {
          break;
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    BagOfTokensScore bots = new BagOfTokensScore();
    bots.bagOfTokensScore(new int[]{100,200}, 150);
  }
}