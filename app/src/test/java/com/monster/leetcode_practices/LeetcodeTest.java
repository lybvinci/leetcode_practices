package com.monster.leetcode_practices;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
//        System.out.print(isIsomorphic("foo", "bar"));
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        reverseList(listNode);
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        myStack.pop();
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

    // 6.2%
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode reverseNode = null;
        if (!stack.empty()) {
            head = stack.peek();
        }
        while (!stack.empty()){
            reverseNode = stack.pop();
            if (!stack.empty()) {
                reverseNode.next = stack.peek();
            }
        }
        reverseNode.next = null;
        return head;
    }

    // 33.75%
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    //19.84%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i - index <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // 59.70%
    class MyStack {

        /** Initialize your data structure here. */
        private Queue<Integer> mQueue = null;
        private Queue<Integer> mQueue2 = null;
        public MyStack() {
            mQueue = new LinkedList<>();
            mQueue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (mQueue.isEmpty() && mQueue2.isEmpty()) {
                mQueue.add(x);
            } else if (mQueue.isEmpty()) {
                mQueue2.add(x);
            } else if (mQueue2.isEmpty()) {
                mQueue.add(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (!mQueue.isEmpty()) {
                int size = mQueue.size() -1;
                for (int i = 0; i<size; i++) {
                    mQueue2.add(mQueue.poll());
                }
                return mQueue.poll();
            } else if (!mQueue2.isEmpty()){
                int size = mQueue2.size() -1;
                for (int i = 0; i<size; i++) {
                    mQueue.add(mQueue2.poll());
                }
                return mQueue2.poll();
            }

            return 0;
        }

        /** Get the top element. */
        public int top() {
            if (!mQueue.isEmpty()) {
                int size = mQueue.size();
                for (int i = 0; i<size - 1; i++) {
                    mQueue2.add(mQueue.poll());
                }
                int res = mQueue.poll();
                mQueue2.add(res);
                return res;
            } else if (!mQueue2.isEmpty()) {
                int size = mQueue2.size();
                for (int i = 0; i<size- 1; i++) {
                    mQueue.add(mQueue2.poll());
                }
                int res = mQueue2.poll();
                mQueue.add(res);
                return res;
            } else {
                return 0;
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mQueue2.isEmpty() && mQueue.isEmpty();

        }
    }
}