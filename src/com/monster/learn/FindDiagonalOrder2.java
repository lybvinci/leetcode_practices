package com.monster.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindDiagonalOrder2 {

    // too slow
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int maxColumn = 0;
        for (int i = 0; i < nums.size(); i++) {
            maxColumn = Math.max(maxColumn, nums.get(i).size());
        }
        List<Integer> ans = new ArrayList<>();
        int columnSum = nums.size() + maxColumn - 1;
        for (int i = 0; i < columnSum; i++) {
            int j = i;
            if (i >= nums.size()) {
                j = nums.size() - 1;
            }
            for (int a = j; a >=0 && i - a >=0 ; a--) {
                int k = i - a;
                List<Integer> sub = nums.get(a);
                if (k < sub.size()) {
                    ans.add(sub.get(k));
                } else {
                    continue;
                }
            }
            
        }
        return ans.stream().mapToInt(i->i).toArray();

    } 

    //14.08%
    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
        int size = nums.size();
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> {
            // 对角线元素下标的规律
            if (a[0] + a[1] == b[0] + b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] + a[1] - b[0] - b[1];
            }
        });
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int len = nums.get(i).size();
            for (int j = 0; j < len; j++) {
                p.add(new int[] { i, j });
            }
            sum += len;
        }
        int[] ans = new int[sum];
        for (int i = 0; i < sum; i++) {
            int[] pop = p.poll();
            ans[i] = nums.get(pop[0]).get(pop[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDiagonalOrder2 fdo2 = new FindDiagonalOrder2();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> item1 = new ArrayList<>();
        item1.add(1);
        item1.add(2);
        item1.add(3);
        nums.add(item1);

        List<Integer> item2 = new ArrayList<>();
        item2.add(4);
        item2.add(5);
        item2.add(6);
        nums.add(item2);


        List<Integer> item3 = new ArrayList<>();
        item3.add(7);
        item3.add(8);
        item3.add(9);
        nums.add(item3);

        fdo2.findDiagonalOrder(nums);
    }

}
