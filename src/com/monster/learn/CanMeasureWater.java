package com.monster.learn;

//43.56%
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        } else if (x == 0) {
            return y == z;
        } else if (y == 0) {
            return x == z;
        } else if (x + y < z) {
            return false;
        }
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        while (max % min != 0) {
            int rem = max % min;
            max = min;
            min = rem;
        }
        return z % min == 0;
    }
}