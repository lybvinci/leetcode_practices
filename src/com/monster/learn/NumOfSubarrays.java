package com.monster.learn;

//8.59%
public class NumOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int avgSum = threshold * k;

        for(int i = 0; i < arr.length; i++) {
            if (i + k > arr.length) {
                break;
            }
            int sum = 0;
            for (int j = i; j < (i + k); j++) {
                sum += arr[j];
            }
            if (sum >= avgSum) {
                count++;
            }
        }

        return count;
    } 

}
