package com.monster.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//94.29%
public class GetHint {

    public static void main(String[] args) {
        GetHint hint = new GetHint();
        String res = hint.getHint("1807", "7810");
        System.out.println("res" + res);
    }

    public String getHint(String secret, String guess) {
        int anum = 0;
        int bnum = 0;
        char[] sa = secret.toCharArray();
        char[] sg = guess.toCharArray();
        int[] v = new int[256];
        for (int i = 0; i < sa.length; i++) {
            if (sa[i] == sg[i]) {
                anum++;
            } else {
                v[sa[i]]++;
            }
        }
        for (int i = 0; i < sg.length; i++) {
            if (sa[i] != sg[i] && v[sg[i]] > 0) {
                bnum++;
                v[sg[i]]--;
            }
        }
        return anum + "A" + bnum + "B";
        
    }
}