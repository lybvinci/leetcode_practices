package com.monster.learn;

public class MinCostToMoveChips {

    // 100.00%
    public int minCostToMoveChips(int[] position) {
        int count1 = 0;
        for (int i : position) {
            count1 += i & 1;
        }
        int count0 = position.length - count1;
        return Math.min(count1, count0);
    } 

}
