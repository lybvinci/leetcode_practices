package com.monster.learn;

import java.util.Arrays;

//69.19%
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] dest = new int[heights.length];
        System.arraycopy(heights, 0, dest, 0, heights.length);
        Arrays.sort(dest);
        int ans = 0;
        for (int i = 0; i < dest.length; i++) {
            if (dest[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }    

    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
        hc.heightChecker(new int[]{1,1,4,2,1,3});
    }

}
