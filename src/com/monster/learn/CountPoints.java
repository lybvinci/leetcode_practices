package com.monster.learn;


//100.00%
public class CountPoints {

    private static int R = 1 << 0;
    private static int G = 1 << 1;
    private static int B = 1 << 2;

    private static int MASK = 0b111;

    public int countPoints(String rings) {
        int ans = 0;
        int[] gan = new int[10];
        char[] ringsArr = rings.toCharArray();
        for (int i = 0; i < ringsArr.length; i++) {
            if (ringsArr[i] == 'R') {
                gan[ringsArr[++i] - '0'] |= R;
            } else if (ringsArr[i] == 'G') {
                gan[ringsArr[++i] - '0'] |= G;
            } else {
                gan[ringsArr[++i] - '0'] |= B;
            }
        }
        for (int i = 0; i < gan.length; i++) {
            if ((gan[i] & MASK) == MASK) {
                ans++;
            }
        }
        return ans;
    } 

}
