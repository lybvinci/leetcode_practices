package com.monster.learn;

//58.12%
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() < 1)
            return 0;
        int start = 0;
        int end = 0;
        int res = 0;
        int[] charNum = new int[26];
        charNum[s.charAt(0) - 'A']++;
        while (s.length() > end) {
            int maxCharCnt = 0;
            for (int i = 0; i < 26; i++) {
                if (charNum[i] > maxCharCnt) {
                    maxCharCnt = charNum[i];
                }

            }
            if (maxCharCnt + k > end - start) {
                end++;
                if (end < s.length()) {
                    charNum[s.charAt(end) - 'A']++;
                }
            } else {
                charNum[s.charAt(start) - 'A']--;
                start++;
            }
            if (maxCharCnt + k > res) {
                res = maxCharCnt + k <= s.length() ? maxCharCnt + k : s.length();
            }
        }
        return res;
    }
}