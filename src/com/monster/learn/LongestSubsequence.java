package com.monster.learn;

import java.util.HashMap;

public class LongestSubsequence {
	//72.83%
	public int longestSubsequence(int[] arr, int difference) {
        // key为最后一个元素，value为最后的这个元素的所在的子序列长度
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : arr) {
            //等差数列的前一项
            int key = num - difference;
            //查询前一项元素，更新子序列长度
            int length = map.getOrDefault(key, 0) + 1;
            map.put(num, length);
            //更新结果
            max = Math.max(max, length);
        }
        return max;
	}
}
