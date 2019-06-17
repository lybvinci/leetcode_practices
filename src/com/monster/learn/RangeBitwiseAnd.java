package com.monster.learn;

public class RangeBitwiseAnd {
    // 33.70%
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0)
            return 0;
        int ans = n;
        while(ans > m)
            ans &= (ans - 1); 
        return ans;
    }
}