package com.monster.learn;

public class GetWinner {

    //81.10%
    public int getWinner(int[] arr, int k) {
        int i = 0;
        int count = 0;
        while (count < k && i < arr.length - 1) {
            if (arr[i] > arr[i+1]) {
                arr[i+1] = arr[i];
                count++;
            } else {
                count = 1;
            }
            i++;
        }

        return arr[i];

    } 

    public static void main(String[] args) {
        GetWinner gw = new GetWinner();
        gw.getWinner(new int[]{2,1,3,5,4,6,7}, 2);
    }

}
