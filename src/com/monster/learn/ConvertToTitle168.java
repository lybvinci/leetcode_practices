package com.monster.learn;

public class ConvertToTitle168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    //100.00%
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, ((char)(((n-1) % 26) + 'A')));
            n = (n -1) / 26;
        }
        return res.toString();
    }
}