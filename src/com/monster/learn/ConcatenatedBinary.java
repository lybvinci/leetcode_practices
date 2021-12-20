package com.monster.learn;

//45.93%
public class ConcatenatedBinary {

    private static long MOD = (long)(1e9 + 7);

    public int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0;
            int j = i;
            while (j > 0) {
                len++;
                j >>= 1;
            }
            ans = (ans << len) + i;
            ans %= MOD;
        }
        return (int)ans;
    } 

}
