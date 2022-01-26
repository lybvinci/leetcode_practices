package com.monster.learn;

public class DuplicateZeros {
    //93.86%
    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j >= arr.length) {
                break;
            }
            if (arr[i] == 0) {
                copy[j] = 0;
                if (j + 1 < arr.length) {
                    copy[++j] = 0;
                }
            } else {
                copy[j] = arr[i];
            }
            j++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = copy[i];
        }
    } 
}
