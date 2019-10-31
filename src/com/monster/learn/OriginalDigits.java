package com.monster.learn;

//62.50%
public class OriginalDigits {
    public String originalDigits(String s) {
        int[] temp = new int[26];
        int[] digit = new int[10];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        digit[0] = temp['z' - 'a'];
        digit[2] = temp['w' - 'a'];
        digit[6] = temp['x' - 'a'];
        digit[8] = temp['g' - 'a'];
        digit[4] = temp['u' - 'a'];

        digit[1] = temp['o' - 'a'] - (digit[0] + digit[2] + digit[4]);
        digit[3] = temp['h' - 'a'] - digit[8];
        digit[5] = temp['f' - 'a'] - digit[4];
        digit[7] = temp['s' - 'a'] - digit[6];
        digit[9] = temp['i' - 'a'] - (digit[6] + digit[8] + digit[5]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit.length; i++) {
            for (int j = 0; j < digit[i]; j++) {
                sb.append(i+"");
            }
        }
        return sb.toString();

    }
}