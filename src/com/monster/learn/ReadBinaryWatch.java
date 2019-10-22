package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//35.05%
public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount((i << 6) + j) == num) {
                    ret.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return ret;
    }

}