package com.monster.learn;

//59.86%
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if ( null == s || null == t) {
            return false;
        }
        int i = 0, j = 0;
        int count = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count == s.length();
    }
}