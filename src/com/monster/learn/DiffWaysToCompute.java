package com.monster.learn;

import java.util.ArrayList;
import java.util.List;
// 30.29%
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> r1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> r2 = diffWaysToCompute(input.substring(i+1));
                for (int i1 : r1) {
                    for (int i2 : r2) {
                        if (c == '+') {
                            res.add(i1 + i2);
                        } else if (c == '-') {
                            res.add(i1 - i2);
                        } else if (c == '*') {
                            res.add(i1 * i2);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}