package com.monster.learn;

//9.26%
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int bitSum = n;
        if (bitSum == 0) {
            return 1;
        } else if (bitSum == 1) {
            return 10;
        }
        int res = 10;
        for (int i = 2; i <= bitSum; i++) {
            // res += 9 * 9; //2 bit
            // res += 9 * 9 * 8;
            // res += 9 * 9 * 8 * 7;
            int tmp = 9;
            for (int j = 0; j <= i - 2; j++) {
                tmp *= 9 - j;
            }
            res += tmp;
        }
        return res;
    }
}