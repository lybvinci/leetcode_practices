package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 1481. 不同整数的最少数目
//给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
public class FindLeastNumOfUniqueInts {

    //27.80%
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        } 
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (count < k) {
                if (entry.getValue() + count < k) {
                    map.remove(entry.getKey());
                    count += entry.getValue();
                } else if (entry.getValue() + count == k) {
                    map.remove(entry.getKey());
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        FindLeastNumOfUniqueInts flnoui = new FindLeastNumOfUniqueInts();
        flnoui.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3);
    }

}
