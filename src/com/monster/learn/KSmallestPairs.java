package com.monster.learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> r = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return r;
        int size = Math.min(nums1.length, k);
        int[] index = new int[size];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer s1 = o1[0] + o1[1];
                Integer s2 = o2[0] + o2[1];
                return s1.compareTo(s2);
            }
        });
        for(int i = 0; i < size; i++){
            queue.add(new int[]{nums1[i], nums2[0], i});
        }
        int count = 0;
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            List<Integer> tmp = new LinkedList<>();
            tmp.add(pair[0]);
            tmp.add(pair[1]);
            r.add(tmp);
            int id = pair[2];
            if(++index[id] < nums2.length)
                queue.add(new int[]{nums1[id], nums2[index[id]], id});
            count++;
            if(count == k)
                break;
        }
        return r;
    }
}