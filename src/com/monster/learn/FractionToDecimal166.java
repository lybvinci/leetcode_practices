package com.monster.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FractionToDecimal166 {
    //71.24%
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        HashMap<Long, Integer> maps = new HashMap<>();
        List<Long> number = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0, beginIndex = -1;
        
        long num = numerator;
        long denom = denominator;
        if (num * denom < 0) {
            sb.append("-");
        }
        num = Math.abs(num);
        denom = Math.abs(denom);
        long v = num / denom;
        sb.append(v);

        num = (num % denom) * 10;
        while (num != 0) {
            if (maps.containsKey(num)) {
                beginIndex = maps.get(num);
                break;
            } else {
                maps.put(num, index++);
                v = num / denom;
                num = (num % denom) * 10;
                number.add(v);
            }
        }
        for (int i = 0; i < index; i++) {
            if (i == 0) {
                sb.append('.');
            }
            if (i == beginIndex) {
                sb.append('(');
            }
            sb.append(number.get(i));
        }
        if (beginIndex != -1) {
            sb.append(')');
        }
        return sb.toString();

    }
}