package com.monster.leetcode_practices;

import org.junit.Test;

import java.util.ArrayList;
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
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.pop();
//        myStack.pop();
//        myStack.pop();
//        moveZeroes(new int[]{0,1,0,3,12});
//        int i = -2147483648;
//        long ii = (long)i;
//        long num = i >0?i:-i;
//        System.out.print(num);
//        isUgly(-2147483648);
        firstBadVersion(5);
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
     *
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
            for (int i = 0; i < s.length(); i++) {
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
            for (int i = 0; i < s1.length; i++) {
                if (s1[i] != t1[i]) {
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
        while (!stack.empty()) {
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
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    //19.84%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
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

        /**
         * Initialize your data structure here.
         */
        private Queue<Integer> mQueue = null;
        private Queue<Integer> mQueue2 = null;

        public MyStack() {
            mQueue = new LinkedList<>();
            mQueue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (mQueue.isEmpty() && mQueue2.isEmpty()) {
                mQueue.add(x);
            } else if (mQueue.isEmpty()) {
                mQueue2.add(x);
            } else if (mQueue2.isEmpty()) {
                mQueue.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (!mQueue.isEmpty()) {
                int size = mQueue.size() - 1;
                for (int i = 0; i < size; i++) {
                    mQueue2.add(mQueue.poll());
                }
                return mQueue.poll();
            } else if (!mQueue2.isEmpty()) {
                int size = mQueue2.size() - 1;
                for (int i = 0; i < size; i++) {
                    mQueue.add(mQueue2.poll());
                }
                return mQueue2.poll();
            }

            return 0;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (!mQueue.isEmpty()) {
                int size = mQueue.size();
                for (int i = 0; i < size - 1; i++) {
                    mQueue2.add(mQueue.poll());
                }
                int res = mQueue.poll();
                mQueue2.add(res);
                return res;
            } else if (!mQueue2.isEmpty()) {
                int size = mQueue2.size();
                for (int i = 0; i < size - 1; i++) {
                    mQueue.add(mQueue2.poll());
                }
                int res = mQueue2.poll();
                mQueue.add(res);
                return res;
            } else {
                return 0;
            }
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return mQueue2.isEmpty() && mQueue.isEmpty();

        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 100%
    public TreeNode invertTree(TreeNode root) {
        TreeNode head = root;
        invertTreeHelper(root);
        return head;
    }

    private void invertTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }

    // 75.82%
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n%2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // 79.87%
    class MyQueue {

        private Stack<Integer> mStack1;
        private Stack<Integer> mStack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            mStack1 = new Stack<>();
            mStack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                mStack1.push(x);
            } else if (mStack1.isEmpty()) {
                int size = mStack2.size();
                for (int i = 0; i< size ;i++) {
                    mStack1.push(mStack2.pop());
                }
                mStack1.push(x);
            } else {
                mStack1.push(x);
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                return 0;
            } else if (mStack1.isEmpty()) {
                return mStack2.pop();
            } else {
                int size = mStack1.size() -1;
                for (int i = 0; i< size;i++) {
                    mStack2.push(mStack1.pop());
                }
                return mStack1.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                return 0;
            } else if (mStack1.isEmpty()) {
                return mStack2.peek();
            } else {
                int size = mStack1.size();
                for (int i = 0; i< size;i++) {
                    mStack2.push(mStack1.pop());
                }
                return mStack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mStack1.isEmpty() && mStack2.isEmpty();
        }
    }

    // 66.09%
    class NumArray {

        private int[] sums;
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            if (nums == null || nums.length == 0 ) {
                return;
            }

        }

        public int sumRange(int i, int j) {
            if (sums == null) {
                this.sums = new int[nums.length];
                this.sums[0] = nums[0];
                for (int k = 1; k< nums.length;k++) {
                    sums[k] = sums[k-1] + nums[k];
                }
            }

            if ( i <= 0) {
                return sums[j];
            } else {
                return nums[i] + (sums[j] - sums[i] );
            }
        }

        // 100%
        public boolean canWinNim(int n) {
            if (n % 4 == 0) {
                return false;
            } else {
                return true;
            }
        }

        // 20.83%
        public boolean wordPattern(String pattern, String str) {
            int parLength = pattern.length();
            String[] splits = str.split(" ");
            if (parLength != splits.length) {
                return false;
            }
            Map<Character, String> m = new HashMap<>();
            for (int i = 0; i< parLength; i++) {
                if (m.containsKey(pattern.charAt(i))) {
                    String t = m.get(pattern.charAt(i));
                    if (!t.equals(splits[i])) {
                        return false;
                    }
                } else {
                    if (m.containsValue(splits[i])) {
                        return false;
                    }
                    m.put(pattern.charAt(i), splits[i]);
                }
            }

            return true;
        }
    }

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        // 28.92%
//        int loop = nums.length;
//        int start = 0;
//        for (int i = 0; i< loop;i++) {
//            if (nums[i] == 0) {
//                int j = i+1;
//                if (j >= loop) {
//                    return;
//                }
//                for (;j<loop;j++) {
//                    if (nums[j] != 0) {
//                        int tmp = nums[j];
//                        nums[i] = tmp;
//                        nums[j] =0;
//                        break;
//                    }
//                }
//            }
//        }
        // 100%
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] =  0;
        }
    }

    //46.13%
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pos = head;
        while(pos != null) {
            list.add(pos.val);
            pos = pos.next;
        }
        for (int i = list.size()-1; i>=0;i--) {
            if (head.val != list.get(i)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 21.87%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) ||
                (root.val <p.val && root.val > q.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val ) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    // 100%
    // ??????????? don't understand
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode temp = node.next;
        node.next = temp.next;
    }

    // 99.83%
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) {
            return false;
        }
        int[] times = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i<sc.length;i++) {
            times[sc[i] - 'a']++;
            times[tc[i] - 'a']--;
        }
        for (int i = 0; i<times.length;i++) {
            if (times[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private List<String> binaryTreePathsRes;
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsRes = new ArrayList<>();
        if (root == null) {
            return binaryTreePathsRes;
        }
        helperBinaryTreePaths(root, "");
        return binaryTreePathsRes;
    }

    private void helperBinaryTreePaths(TreeNode root, String path) {
        if (root == null) {
            if (!"".equals(path)) {
                binaryTreePathsRes.add(path);
            }
            return;
        }
        if ("".equals(path)) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            if (!"".equals(path)) {
                binaryTreePathsRes.add(path);
            }
            return;
        } else if (root.left == null) {
            helperBinaryTreePaths(root.right, path);
        } else if (root.right == null) {
            helperBinaryTreePaths(root.left, path);
        } else {
            helperBinaryTreePaths(root.left, path);
            helperBinaryTreePaths(root.right, path);
        }
    }

    //79.12%
    public int addDigits(int num) {
        while(num > 9) {
            int sum = 0;
            while(num != 0) {
                sum += num % 10 ;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    // 85.56%
    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        }
        int i = 2;
        if ( n >= 0) {
            while (i <= n) {
                if (n % 5 == 0) {
                    n /= 5;
                } else if (n % 3 == 0) {
                    n /= 3;
                } else if (n % 2 == 0) {
                    n /= 2;
                } else {
                    return false;
                }
            }
        } else {
            while (i >= n) {
                if (n % 5 == 0) {
                    n /= 5;
                } else if (n % 3 == 0) {
                    n /= 3;
                } else if (n % 2 == 0) {
                    n /= 2;
                } else {
                    return false;
                }
            }
        }

        return true;

    }

    // 95.74%
    public int missingNumber(int[] nums) {
        boolean[] b = new boolean[nums.length+1];
        for (int i = 0; i < nums.length;i++) {
            b[nums[i]] = true;
        }
        for (int i = 0; i < b.length;i++) {
            if (b[i] == false) {
                return i;
            }
        }
        return 0;
    }

    // 95.62%
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
    // for test
    private boolean isBadVersion(int n) {
        return n==4;
    }
}