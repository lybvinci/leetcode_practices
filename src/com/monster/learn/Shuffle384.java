package com.monster.learn;

import java.util.Arrays;
import java.util.Random;

//86.53%
public class Shuffle384 {
    private int[] origin;
    public Shuffle384(int[] nums) {
        origin = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] currentNums = Arrays.copyOf(origin, origin.length);
        Random randNum = new Random();
        for (int i = currentNums.length - 1; i >= 0; i--) {
            int selectedElem = randNum.nextInt(i + 1);
            
            int temp = currentNums[selectedElem];
            currentNums[selectedElem] = currentNums[i];
            currentNums[i] = temp;
        }
        return currentNums;
    }
}