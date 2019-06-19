package com.monster.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    // 72.57%
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, new LinkedList<>(), result);
        return result;
    }

    private static void helper(int index, int k, int n, LinkedList<Integer> tmp, List<List<Integer>> result) {
         if (n == 0 && tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
             return;
         }
         for (int i = index; i < 10; i++) {
             tmp.addLast(i);
             helper(i+1, k, n-i, tmp, result);
             tmp.removeLast();
         }
    }
}