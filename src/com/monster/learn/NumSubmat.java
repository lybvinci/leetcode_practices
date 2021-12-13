package com.monster.learn;

import java.util.Stack;

public class NumSubmat {

    //21.56%
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // h[] records the maximum length of '1' that a cell can extends upwards
        int[] h = new int[n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            Stack<Integer> stk = new Stack<>();
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                h[j] = mat[i][j] == 1 ? 1 + h[j] : 0;
                while (!stk.empty() && h[stk.peek()] > h[j]) {
                    int idx = stk.pop();
                    int len = idx - (stk.empty() ? -1 : stk.peek());
                    sum -= len * (h[idx] - h[j]);
                }
                stk.push(j);
                sum += h[j];
                ans += sum;
            }
        }
        return ans;
    } 

    //61.08%
    public int numSubmat2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    temp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    temp[i][j] = temp[i][j-1] + 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        } 

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = temp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, temp[k][j]);
                    ans += width;
                    if (width == 0) {
                        break;
                    }            
                }
            }
        }

        return ans;
    } 
    
}
