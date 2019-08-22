package com.monster.learn;

//99.70%
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i -1)] + 1;
        }
        return res;
    }
}