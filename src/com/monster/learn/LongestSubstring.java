package com.monster.learn;

//23.83%
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        return helper(s, k, 0, s.length() - 1);
    }

    private int helper(String s, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                int pos = s.indexOf((char)(i + 'a'), start);
                return Math.max(helper(s, k, start, pos - 1), helper(s, k, pos + 1, end));
            }
        }
        return end - start + 1;
    }
}