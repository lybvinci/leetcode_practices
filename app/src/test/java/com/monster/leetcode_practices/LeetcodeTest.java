package com.monster.leetcode_practices;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
//        System.out.print(isHappy(3));
        System.out.print(isIsomorphic("foo", "bar"));
    }

    public int trailingZeroes(int n) {
        String res = "" + helper(n);
        int result = 0;
        for (int j = res.length() - 1; j >= 0; j--) {
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
            return n * helper(n - 1);
        }
    }


    public void rotate(int[] nums, int k) {
        int temp = 0;
        int temp2 = 0;
        int times = nums.length / k;
        for (int i = 0; i < times; i++) {
            temp = nums[i];
            for (int j = i; j < nums.length; ) {
                temp2 = nums[(j + k) % nums.length];
                nums[(j + k) % nums.length] = temp;
                temp = temp2;
                j += k;
                if (j > nums.length) {
                    nums[i] = temp;
                }
            }
        }

    }

    public int hammingWeight(int n) {
        String n2 = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < n2.length(); i++) {
            if (n2.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public int reverseBits(int n) {
        String rs = Integer.toBinaryString(n);
        int add = 32 - rs.length();
        for (int i = 0; i < add; i++) {
            rs = "0" + rs;
        }
        rs = (new StringBuilder(rs)).reverse().toString();
        return (int) Long.parseLong(rs, 2);
    }

    /**
     * 多写几个例子。会发现n不能包含4
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int t = 0;
            while (n > 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
        }
        return n == 1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 29.61%
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode handle = head;
        while (handle != null && handle.val == val) {
            handle = handle.next;
        }
        head = handle;
        while (handle != null && handle.next != null) {
            if (handle.next.val == val) {
                handle.next = handle.next.next;
            } else {
                handle = handle.next;
            }
        }
        return head;
    }

    // 2.35% ...
    public boolean isIsomorphic(String s, String t) {
        if (null == s && null == t) {
            return true;
        } else if (null == s || null == t) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        } else {
            char[] s1 = new char[s.length()];
            char[] t1 = new char[t.length()];
            Map<Character, Character> sm1 = new HashMap<>();
            Map<Character, Character> tm1 = new HashMap<>();
            char start1 = 0;
            char start2 = 0;
            for (int i = 0; i < s.length(); i++){
                boolean i1 = sm1.containsKey(s.charAt(i));
                boolean i2 = tm1.containsKey(t.charAt(i));
                if (i1 == i2) {
                    if (i1) {
                        s1[i] = sm1.get(s.charAt(i));
                        t1[i] = tm1.get(t.charAt(i));
                    } else {
                        s1[i] = start1;
                        sm1.put(s.charAt(i), start1);
                        start1 += 1;

                        t1[i] = start2;
                        tm1.put(t.charAt(i), start2);
                        start2 += 1;
                    }
                } else {
                    return false;
                }

            }
            for (int i = 0;i<s1.length; i++) {
                if (s1[i]!= t1[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}