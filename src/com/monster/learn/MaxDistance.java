package com.monster.learn;

import java.util.HashMap;


//30.56%
public class MaxDistance {

    public int maxDistance(int[] colors) {
        int ans = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    ans = Math.max(ans, Math.abs(i - j));
                }
            }
        }
        return ans;
    } 

}
