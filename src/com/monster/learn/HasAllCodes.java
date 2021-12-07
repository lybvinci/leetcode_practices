package com.monster.learn;

import java.util.HashSet;

//62.91%
public class HasAllCodes {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        int len = (int)Math.pow(2, k);
        int end = s.length() - k + 1;
        for (int i = 0; i < end; i++) {
            String st = s.substring(i, i + k);
            set.add(st);
            if (set.size() == len) {
                return true;
            }
        }
        
        return false;
    } 

}
