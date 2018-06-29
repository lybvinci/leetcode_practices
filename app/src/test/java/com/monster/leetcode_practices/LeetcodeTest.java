package com.monster.leetcode_practices;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LeetcodeTest {
    @Test
    public void main() {
        int n = 25;
//        trailingZeroes(25);
//        rotate(new int[]{1,2,3,4,5,6,7}, 3);
//        hammingWeight(  4294967295);
//        reverseBits(43261596);
        System.out.print(isHappy(3));
    }

    public int trailingZeroes(int n) {
        String res = "" + helper(n);
        int result = 0;
        for (int j = res.length()-1;j>=0;j--) {
            if (res.charAt(j) == '0') {
                result++;
            } else {
                return result;
            }
        }
        return result;

    }
    private double helper(int n) {
        if (n == 1) {
            return n;
        } else {
            return n*helper(n-1);
        }
    }


    public void rotate(int[] nums, int k) {
        int temp = 0;
        int temp2 = 0;
        int times = nums.length / k;
        for (int i = 0; i< times; i++) {
            temp = nums[i];
            for (int j = i; j<nums.length;) {
                temp2 = nums[(j+k)%nums.length];
                nums[(j+k)%nums.length] = temp;
                temp = temp2;
                j += k;
                if ( j > nums.length) {
                    nums[i] = temp;
                }
            }
        }

    }

    public int hammingWeight(int n) {
        String n2 = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i<n2.length();i++) {
            if (n2.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public int reverseBits(int n) {
        String rs = Integer.toBinaryString(n);
        int add = 32 - rs.length();
        for (int i = 0 ;i<add;i++) {
            rs = "0" + rs;
        }
        rs = (new StringBuilder(rs)).reverse().toString();
        return (int)Long.parseLong(rs, 2);
    }

    /**
     * 多写几个例子。会发现n不能包含4
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int t = 0;
            while (n > 0) {
                t += (n%10)*(n%10);
                n /= 10;
            }
            n = t;
        }
        return n ==1;
    }
}