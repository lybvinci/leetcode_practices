package com.monster.learn;

import java.util.LinkedList;

//5.04%
public class ReverseVowels {
    public String reverseVowels(String s) {
        LinkedList<Integer> indexes = new LinkedList<>();
        StringBuilder vowels = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o'
                || arr[i] == 'u' || arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O'
                || arr[i] == 'U') {
                    indexes.add(i);
                    vowels.append(arr[i]);
                }
        }
        char[] vos = vowels.reverse().toString().toCharArray();
        for (int i = 0; i < indexes.size(); i++) {
            arr[indexes.get(i)] = vos[i];
        }
        return new String(arr);
    }
}