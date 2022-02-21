package com.monster.learn;

import java.util.HashMap;
import java.util.Map;

public class CountWords {
    //20.34%
    public int countWords(String[] words1, String[] words2) {
        int ans = 0;
        Map<String, Integer> w1 = new HashMap<>();
        Map<String, Integer> w2 = new HashMap<>();
        for (String s : words1) {
            w1.put(s, w1.getOrDefault(s, 0) + 1);
        } 

        for (String s : words2) {
            w2.put(s, w2.getOrDefault(s, 0) + 1);
        } 
        for (Map.Entry<String, Integer> entry : w1.entrySet()) {
            if (entry.getValue() == 1) {
                if (w2.getOrDefault(entry.getKey(), 0) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    } 
}
