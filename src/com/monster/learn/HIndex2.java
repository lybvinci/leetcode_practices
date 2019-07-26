package com.monster.learn;

import java.util.Arrays;

//7.59%
public class HIndex2 {
    public int hIndex(int[] citations) {
    //    Arrays.sort(citations); 
       int level = 0;
       for (int i = 0; i < citations.length; i++) {
           level = Math.max(level, Math.min(citations.length - i, citations[i]));
       }
       return level;
    }
}