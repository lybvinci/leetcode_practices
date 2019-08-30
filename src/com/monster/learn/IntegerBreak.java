package com.monster.learn;

//88.93%
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        if (n % 2 == 0) {
            int numOf3 = n / 6 * 2;
            int numOf2 = n % 6 / 2;
            return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
        } else {
            int numOf3 = (n -3) / 6 * 2 + 1;
            int numOf2 = (n - 3)  % 6 / 2;
            return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
        }
    }
}