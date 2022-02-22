package com.monster.learn;

public class GenerateTheString {

    //100.00%
    public String generateTheString(int n) {
        char[] chars = new char[n];
        int i = 0;
        if (n % 2 == 0) {
            chars[i++] = 'a';
        }
        for (; i < n; i++) {
            chars[i] = 'b';
        }

        return String.valueOf(chars);
    } 

}
