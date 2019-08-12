package com.monster.learn;

//69.70%
public class MaxProduct318 {
    public int maxProduct(String[] words) {
        int[] wordsInts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int tmp = 0;
            for (int j = 0; j < words[i].length(); j++) {
                tmp |= 1 << (words[i].charAt(j) - 'a'); 
            }
            wordsInts[i] = tmp;
        }
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordsInts[i] & wordsInts[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}