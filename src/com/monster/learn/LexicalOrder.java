package com.monster.learn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//16.22%
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            ret.add(i);
        }
        ret.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return (i1 + "").compareTo(i2 + "");
            }
        });
        return ret;
    }
}