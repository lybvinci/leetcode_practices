package com.monster.learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAAA");
    }

    // 30.94%
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        int mask = 0x7ffffff;
        int cur = 0;
        for (int i = 0; i < 9; i++) {
            cur = cur << 3 | (s.charAt(i) & 7);
        }
        for (int i = 9; i < s.length(); i++) {
            cur = (cur & mask) << 3 | (s.charAt(i) & 7);
            if (set.contains(cur)) {
                list.add(s.substring(i - 9, i + 1));
            } else {
                set.add(cur);
            }
        }
        
        return new ArrayList<String>(list);
            
    }
}