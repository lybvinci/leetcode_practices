package com.monster.learn;

//100.00%
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        NumberOfArithmeticSlices obj = new NumberOfArithmeticSlices();
        obj.numberOfArithmeticSlices(new int[]{7,7,7,7,1,2,3});
    }


    public int numberOfArithmeticSlices(int[] A) {
      int ret = 0;
      if (A.length < 3) {
        return ret;
      }  
      int start = 0;
      int end = 0;
      boolean hasStart = false;
      for (int i = 2; i < A.length; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            if (hasStart) {
                end = i;
            } else {
                start = i - 2;
                hasStart = true;
            }
        } else {
            if (hasStart) {
                end = i - 1;
               int length = end - start + 1;
               int temp = 3;
               while (temp <= length) {
                ret += length - temp + 1;
                temp++;
               } 
               hasStart = false;
            }
        }
      }
      if (hasStart) {
        end = A.length - 1;
        int length = end - start + 1;
        int temp = 3;
        while (temp <= length) {
         ret += length - temp + 1;
         temp++;
        } 
        hasStart = false;
      }
      return ret;
    }
}