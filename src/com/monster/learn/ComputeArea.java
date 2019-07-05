package com.monster.learn;

//65.36%
public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s = (C - A) * (D - B) + (G - E) * (H -F);
        if (C <= E || F >= D || B >= H || A >= G) {
            return s;
        }
        int topX = Math.min(G, C);
        int topY = Math.min(H, D);
        int bottomX = Math.max(E, A);
        int bottomY = Math.max(B, F);
        return s - (topX - bottomX) * (topY - bottomY);
    }
}