package com.monster.learn;

import java.util.Arrays;

//91.20%
public class WiggleSort {


    public static void main(String[] args) {
        WiggleSort sort = new WiggleSort();
        sort.wiggleSort(new int[]{1,2,3,4,5,6});
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);    
        int[] copy = nums.clone();
        int index = 1;

        for (int i = nums.length - 1; i > (nums.length -1) /2; i--) {
            nums[index] = copy[i];
            index += 2;
        }
        index = 0;
        for (int i = (nums.length - 1)/ 2; i >= 0; i--) {
            nums[index] = copy[i];
            index += 2;
        }
        
    }
}