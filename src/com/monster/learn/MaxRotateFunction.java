package com.monster.learn;

//20.69%
public class MaxRotateFunction {

    public static void main(String[] args) {
        MaxRotateFunction obj = new MaxRotateFunction();
        obj.maxRotateFunction(new int[]{-2147483648,-2147483648});
    }

    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if (n < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int ii = i;
            for (int j = 0; j < n - i; j++) {
                sum += ii * A[j];
                ii++;
            }
            ii = 0;
            for (int j = n - i; j < n; j++) {
                sum += ii * A[j];
                ii++;
            }
            System.out.println("sum=" + sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}