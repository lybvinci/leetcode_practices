package com.monster.learn;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
    }


    // 63.08%
    public static String largestNumber(int[] nums) {
        Integer[] nn = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nn[i] = nums[i];
        }
        Arrays.sort(nn, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                }
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        if (nn[nn.length - 1] == 0) {
            return "0";
        }
        for (int i = nn.length - 1; i >= 0; i--) {
            sb.append(nn[i]);
        }
        return sb.toString();
    }
}