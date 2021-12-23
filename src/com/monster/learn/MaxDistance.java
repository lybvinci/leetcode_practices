package com.monster.learn;

import java.util.HashMap;


//30.56%
public class MaxDistance {

    public int maxDistance(int[] colors) {
        int ans = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    } 

}
