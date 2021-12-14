package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CountSmaller {

    // too slow
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }        
            }
            ans.add(count);
        }


        return ans;
    }    

    //9.98%
    public List<Integer> countSmaller2(int[] nums) {
        Integer[] res = new Integer[nums.length];
        // sort其实是关键。sort的目的是 对i后面的元素进行从小到大的排序。
        // 每次插入新的数值，前面有几个数就是这个数值现在的逆序数
        List<Integer> sorted = new ArrayList<>(nums.length);
        int length = nums.length;
        // 从后往前计算
        for (int i = length - 1; i >= 0; i--) {
            int idx = binarySearch(sorted, nums[i]);
            res[i] = idx;
            // 实现对sorted的排序。
            sorted.add(idx, nums[i]);
        }

        return Arrays.asList(res);
    }

    // 使用二分法。找大于或等于key的第一个位置
    private int binarySearch(List<Integer> list, int key) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        CountSmaller cs = new CountSmaller();
        cs.countSmaller2(new int[]{2,0,1});
    }

}
