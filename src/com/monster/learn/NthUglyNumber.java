package com.monster.learn;

// 90.79%
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] u = new int[n];
        u[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int k = 1;
        while (k < n) {
            u[k] = min(u[index2]*2, u[index3]*3, u[index5]*5);
            if (u[index2]*2 == u[k]) index2++;
            if (u[index3]*3 == u[k]) index3++;
            if (u[index5]*5 == u[k]) index5++;
            k++;
        }
        return u[n-1];
    }

    private int min(int a, int b, int c) {
        return a > b?(b < c ? b : c) : (a < c ? a:c);
    }
}