package com.monster.learn;

public class CountArrangement {

    //57.22%
    public int countArrangement(int n) {
        return getCount(1, n, new boolean[n + 1]);
    }

    private int getCount(int i, int n, boolean[] used) {
        if (i > n) {
            return 1;
        }
        int count = 0;
        for (int j = 1; j <= n; j++) {
            if (!used[j] && (j % i == 0 || i % j == 0)) {
                used[j] = true;
                count += getCount(i + 1, n, used);
                used[j] = false;
            }
        }
        return count;
    }

}