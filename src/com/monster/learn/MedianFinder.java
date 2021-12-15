package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // too slow
    // ArrayList<Integer> list;

    // public MedianFinder() {
    //     list = new ArrayList<>();
    // }
    
    // public void addNum(int num) {
    //     list.add(num);
    //     Collections.sort(list);
    // }
    
    // public double findMedian() {
    //     int size = list.size();
    //     if (size % 2 == 0) {
    //         return (list.get(size / 2 - 1) + list.get(size / 2))/2.0d;
    //     } else {
    //         return list.get(size / 2);
    //     }
    // } 

    //30.90%
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }
    
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0d;
        }
    }
}
