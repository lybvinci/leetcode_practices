package com.monster.learn;

import java.util.List;

public class Hanota {
    //35.95%
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        helper(A.size(), A, B, C);
    } 

    private void helper(int size, List<Integer> start, List<Integer> medium, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        helper(size - 1, start, target, medium);
        target.add(start.remove(start.size() - 1));
        helper(size - 1, medium, start, target);
    }
}
