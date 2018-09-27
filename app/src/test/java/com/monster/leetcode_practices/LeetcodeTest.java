package com.monster.leetcode_practices;

import android.util.ArraySet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LeetcodeTest {
    @Test
    public void main() {
//        int n = 25;
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
//        firstBadVersion(5);
//        isPowerOfThree(27);
//        guessNumber(10);
//        canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi");
//        firstUniqChar("loveleetcode");
//        addStrings("98", "9");
//        compress(new char[]{'a','a','a','b','b','a','a'});
//        arrangeCoins(1804289383);
//        findAnagrams("cbaebabacd", "abc");
//        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
//        repeatedSubstringPattern("abab");
//        findComplement(5);
//        licenseKeyFormatting("5F3Z-2e-9-w", 4);
//        findLUSlength("aba", "bacdef");
//        reverseStr("abcdefg", 2);
//        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(-3);
//
//        root.left = left;
//        root.right = right;
//        findFrequentTreeSum(root);
        checkRecord("PPALLL");
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

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if ( n == 1) {
            return true;
        }
        int left = n % 10;
        if (left != 3 && left != 9 && left != 7 && left != 1) {
            return false;
        }
        int sum = 0;
        int tmp = n;
        while (tmp != 0) {
            sum += tmp %10;
            tmp /= 10;
        }
        if (sum % 3 != 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n/=3;
        }
        return true;

    }

    // 11.20%
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        if ( num == 1) {
            return true;
        }
        int left = num % 10;
        if (left != 4 && left != 6) {
            return false;
        }

        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            }
            num/=4;
        }
        return true;
    }

    //73.87%
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    // 33.64%
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length ==0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> result = new HashSet<>();
        List<Integer> nums2L = new ArrayList<>();
        for (int i = 0; i<nums2.length;i++) {
            nums2L.add(nums2[i]);
        }
        for (int i = 0; i< nums1.length;i++) {
            if (nums2L.contains(nums1[i])) {
                result.add(nums1[i]);
                int index = nums2L.indexOf(nums1[i]);
                nums2L.remove(index);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();

    }

    // 18.67%
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length ==0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> nums2L = new ArrayList<>();
        for (int i = 0; i<nums2.length;i++) {
            nums2L.add(nums2[i]);
        }
        for (int i = 0; i< nums1.length;i++) {
            if (nums2L.contains(nums1[i])) {
                result.add(nums1[i]);
                int index = nums2L.indexOf(nums1[i]);
                nums2L.remove(index);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    //56.79%
    public boolean isPerfectSquare(int num) {
        int left = num % 10;
        if (left == 3 || left == 7 || left == 8) {
            return false;
        }
        int start = 0;
        int temp = 0;
        while (temp < num) {
            temp = start*start;
            start++;
        }
        return temp == num;
    }

    // 100%
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }

    // 99.65%
    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2, t = guess(mid);
            if (t == 0) return mid;
            else if (t == 1) left = mid;
            else right = mid;
        }
        return left;
    }
    private int guess(int n ){
        if (n == 6) {
            return 0;
        } else if (n > 6) {
            return 1;
        } else {
            return -1;
        }
    }

    // 54.28%
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mC = magazine.toCharArray();
        char[] rC = ransomNote.toCharArray();
        for (int i = 0; i< rC.length;i++) {
            int j = 0;
            for (; j< mC.length;j++) {
                if (rC[i] == mC[j]) {
                    mC[j] = '\n';
                    break;
                }
            }
            if (j == mC.length) {
                return false;
            }
        }
        return true;
    }

    //82.96%
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i =0;i<chars.length;i++) {
            int index = s.indexOf(chars[i], i+1);
            if (index != -1) {
                continue;
            } else {
                int index2 = s.indexOf(chars[i]);
                if (index2 == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 56%
    public char findTheDifference(String s, String t) {
        int[] res = new int[26];
        for (int i = 0; i < s.length();i++) {
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }
        res[t.charAt(t.length()-1) - 'a']--;
        for (int i = 0; i<res.length;i++) {
            if (res[i] == -1) {
                return (char)('a'+i);
            }
        }
        return ' ';
    }

    //62/03%
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j) - '0';
            }
            builder.append((char)(carry % 10 + '0'));
            carry /= 10;
            i--;
            j--;
        }
        if (carry == 1) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }

    // 52.84%
    public int numberOfBoomerangs(int[][] points) {
        // int result = 0;
        // for (int i = 0; i<points.length;i++) {
        //     for (int j = 0; j < points.length; j++) {
        //         if (j == i) {
        //             continue;
        //         }
        //         for (int k = 0; k<points.length;k++) {
        //             if (k == i || k == j) {
        //                 continue;
        //             }
        //             long dis1 = (long)(Math.pow((points[i][1] - points[j][1]),2) + Math.pow(points[i][0] - points[j][0],2));
        //             long dis2 = (long)(Math.pow((points[i][1] - points[k][1]),2) + Math.pow(points[i][0] - points[k][0],2));
        //             if (dis1 == dis2) {
        //                 result ++;
        //             }
        //         }
        //     }
        // }
        // return result;
        int result = 0;
        for (int[] pointA : points) {
            Map<Integer, Integer> distances = new HashMap<>();
            for (int[] pointB : points) {
                int distance = (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            for (int item : distances.values()) {
                result += item * (item - 1);
            }
        }
        return result;
    }

    // 52.53%
    public int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i<chars.length;i++) {
            int num = 1;
            int j = i+1;
            for (;j<chars.length;j++) {
                if (chars[i] == chars[j]) {
                    num++;
                } else {
                    break;
                }
            }
            chars[index] = chars[i];
            index++;
            if (num > 1) {
                Stack<Integer> stack = new Stack<>();
                while (num >0) {
                    stack.push(num%10);
                    num /= 10;
                }
                while (!stack.isEmpty()) {
                    chars[index++] = (char)(stack.pop() + '0');
                }
                i = j-1;
            }
        }
        return index;
    }

    //74.37%
    public int arrangeCoins(int n) {
        long t = (long)n;
        return (int)(Math.sqrt(1+ 8*t) - 1)/2;
    }

    //6%
    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        char[] sc = s.toCharArray();
//        char[] sp = p.toCharArray();
//        for (int i = 0 ; i< sc.length;i++) {
//            if (i+sp.length > sc.length) {
//                return result;
//            }
//            int startSc = i;
//            int endSc = startSc + p.length();
//            Set<Integer> temp = new HashSet<>();
//            for (int j = 0; j < sp.length; j++) {
//                for (int k = startSc; k < endSc; k++) {
//                    if (temp.contains(k)) {
//                        continue;
//                    }
//                    if (sc[k] == sp[j]) {
//                        temp.add(k);
//                        break;
//                    }
//                }
//            }
//            if (temp.size() == sp.length) {
//                result.add(i);
//            }
//        }
//        return result;
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n)
            return list;
        for (int i = 0; i <= m - n; i++) {
            int[] t = new int[26];
            for (int j = 0; j < n; j++) {
                t[s.charAt(i + j)-'a']++;
                t[p.charAt(j)-'a']--;
            }
            boolean flag = true;
            for (int j = 0; j < t.length; j++) {
                if (t[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(i);
        }
        return list;
    }

    // 19.98%
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int d3 = 0;
        int d5 = 0;
        for (int i = 1; i <= n;i++) {
            d3 = i % 3;
            d5 = i % 5;
            if (d3 ==0 && d5 ==0) {
                result.add("FizzBuzz");
            } else if (d3 == 0) {
                result.add("Fizz");
            } else if (d5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // 12.50%
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<List<Node>> temp = new LinkedList<>();
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);
        if (root.children != null) {
            temp.add(root.children);
        }
        while(!temp.isEmpty()) {
            int size = temp.size();
            ArrayList<Integer> childList = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                List<Node> poll = temp.poll();
                if (poll != null && poll.size() != 0) {
                    for (Node n : poll) {
                        childList.add(n.val);
                        if (n.children != null) {
                            temp.add(n.children);
                        }
                    }
                }
            }
            if (childList.size() != 0) {
                result.add(childList);
            }


        }

        return result;

    }

    // 99.73%
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i<nums.length; i ++)   {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }

    //84.91%
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    // 14.81%
    public int longestPalindrome(String s) {
        Map<Character, Integer> container = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length; i++) {
            if (container.containsKey(chars[i])) {
                container.put(chars[i], container.get(chars[i]) + 1);
            } else {
                container.put(chars[i], 1);
            }
        }
        int result = 0;
        for (Character key : container.keySet()) {
            result += container.get(key) / 2;
        }
        return result * 2 < s.length() ? result*2 + 1 : result * 2;
    }

    // 40.12%
    public int findNthDigit(int n) {
        int digitType = 1;
        long digitNum = 9;
        //定位到是几位数
        while(n > digitNum*digitType){
            n -= (int) digitNum*digitType ;
            digitType++;
            digitNum*=10;
        }
        //定位到是这些几位数里面的第几个的第几位
        int indexInSubRange = (n -1) / digitType;
        int indexInNum = (n -1) % digitType;
        //还原数字
        int num = (int)Math.pow(10,digitType - 1) + indexInSubRange ;
        int result = Integer.parseInt((""+num).charAt(indexInNum)+"");
        return result;
    }

    //56.78%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) -1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i<nums.length;i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
        // too slow
//        for (int i = 0; i< nums.length; i++) {
//            if (i+1 == nums[i]) {
//                continue;
//            }
//            boolean has = false;
//            int j = 0;
//            for (; j < nums.length; j++) {
//                if (i+1 == nums[j]) {
//                    has = true;
//                    break;
//                }
//            }
//            if (!has) {
//                res.add(i+1);
//            }
//        }
//        return res;
    }

    //24.03%
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length < 2) {
            return 0;
        } else {
            int sum = 0;
            for (int i = 1 ; i < nums.length; i++) {
                sum += nums[i] - nums[0];
            }
            return sum;
        }
    }

    //61.72%
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0 ,j = 0; i < g.length && j <s.length ;) {
            if (s[j] >= g[i]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;

    }

    // 94.12%
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));

    }

    // 48.95%
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1; i <= n / 2; i++){
            if(n % i != 0) continue;
            String refer = s.substring(0, i);
            int a = 1;
            for(int j = i; j < n; j = j + i){
                String tmp = s.substring(j, j+i);
                if(!refer.equals(tmp)){
                    a = 0;
                    break;
                }
            }
            if(a == 1) return true;
        }
        return false;
    }

    //19.24%
    public int hammingDistance(int x, int y) {
        int sum = 0;
        int temp = x ^ y;
        while(temp > 0) {
            sum += temp & 0x1;
            temp = temp >> 1;
        }
        return sum;
    }

    // 95.69%
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (tmp > 0) {
                    result = Math.max(tmp, result);
                }
                tmp = 0;
            } else {
                tmp++;
            }
        }
        result = Math.max(tmp, result);
        return result;
    }

    // 16.44%
    public int findComplement(int num) {
        int mask = 1;
        int temp = num;
        while (temp > 0) {
            mask <<= 1;
            temp >>= 1;
        }
        return num ^ (mask -1);
    }

    // 34.78%
    public String licenseKeyFormatting(String S, int K) {
        String no_S = S.replaceAll("-", "");
        int segNum = (no_S.length() -1)/K;
        int left = (no_S.length() - 1) % K;
        int firstLength = 1 + left;
//        too slow
//        String res = no_S.substring(0, firstLength) + "-";
//        for (int i = 0; i < segNum; i++) {
//            res += no_S.substring(firstLength + i*K, firstLength + (i+1) * K) + "-";
//        }
//        return res.substring(0, res.length()-1).toUpperCase();
        StringBuilder sb = new StringBuilder(no_S.length());
        char[] no_SChars = no_S.toCharArray();
        sb.append(no_S.substring(0, firstLength)).append("-");
        int temp = 1;
        for (int i = firstLength; i < no_SChars.length; i++) {
            sb.append(no_SChars[i]);
            if (++temp == K) {
                sb.append("-");
                temp = 1;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString().toUpperCase();

    }

    //35.61%
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.floor( Math.sqrt(area));
        for (int i = sqrt; i <= area ; i++) {
            if (area % i == 0) {
                int left = area / i;
                return left > i ? new int[]{left, i} : new int[]{i, left};
            }
        }
        return null;

    }

    // 46.55%
    public String convertToBase7(int num) {
        String res = "";
        boolean flag = num >= 0 ;
        long temp = num;
        temp = Math.abs(temp);
        while ( temp >= 7) {
            res = temp % 7 + res;
            temp /= 7;
        }
        res = temp + res;
        if (!flag) {
            res = "-" + res;
        }
        return res;
    }

    // 24.19%
    public String[] findRelativeRanks(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int level = list.indexOf(nums[i]);
            if (level == 0) {
                result[i] = "Gold Medal";
            } else if (level == 1) {
                result[i] = "Silver Medal";
            } else if (level == 2) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = level + 1 + "";
            }
        }
        return result;
    }

    // 27.33%
    Set<Character> first = new HashSet<Character>() {
        {
            add('q');add('w');add('e');add('r');add('t');add('y');add('u');add('i');add('o');add('p');
        }
    };
    Set<Character> second = new HashSet<Character>() {
        {
            add('a');add('s');add('d');add('f');add('g');add('h');add('j');add('k');add('l');
        }
    };
    Set<Character> third = new HashSet<Character>() {
        {
            add('z');add('x');add('c');add('v');add('b');add('n');add('m');
        }
    };
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            if (words[i].length() <= 0) {
                continue;
            }
            char[] chars = words[i].toLowerCase().toCharArray();
            Set<Character> temp = null;
            if (first.contains(chars[0])) {
                temp = first;
            } else if (second.contains(chars[0])) {
                temp = second;
            } else if (third.contains(chars[0])) {
                temp = third;
            }
            boolean is = true;

            for (int j = 1; j < chars.length ; j++) {
                if (!temp.contains(chars[j])) {
                    is = false;
                    break;
                }
            }
            if (is) {
                result.add(words[i]);
            }
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    //1.75%
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        helperFindMode(root, map);
        Set<Integer> keys  = new HashSet<>();
        int max = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                keys.clear();
                keys.add(key);
            } else if (map.get(key) == max) {
                keys.add(key);
            }
        }
        return keys.stream().mapToInt(Number::intValue).toArray();
    }
    private void helperFindMode(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        helperFindMode(root.left, map);
        helperFindMode(root.right, map);
    }

    //16.70%
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean start = false;
            boolean hasGT = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    start = true;
                    continue;
                }
                if (start && nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    hasGT = true;
                    break;
                }

            }
            if (!hasGT) {
                result[i] = -1;
            }
        }
        return result;
    }

    // 45.67%
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        char[] chars = word.toCharArray();
        boolean firstIsUpper = false;
        boolean secondIsUpper = false;
        if (chars[0] < 'a') {
            firstIsUpper = true;
            if (chars[1] < 'a') {
                secondIsUpper = true;
            }
        }
        int i = 1;
        if (firstIsUpper) {
            i = 2;
        }
        for (; i < chars.length; i++) {
            if (firstIsUpper && secondIsUpper) {
                if (chars[i] >= 'a') {
                    return false;
                }
            } else if (firstIsUpper && !secondIsUpper){
                if (chars[i] < 'a') {
                    return false;
                }
            } else {
                if (chars[i] < 'a') {
                    return false;
                }
            }
        }
        return true;
    }

    //98.62%
    public int findBottomLeftValue(TreeNode root) {
        return helperFindBottomLeftValue(root,0)[0];
    }
    private int[] helperFindBottomLeftValue(TreeNode root,int level) {
        int[] res;
        if (root.left == null && root.right == null) {
            return new int[]{root.val, level};
        } else if (root.left == null) {
            res = helperFindBottomLeftValue(root.right, level+1);
        } else if (root.right == null) {
            res = helperFindBottomLeftValue(root.left, level+1);
        } else {
            int[] t1 = helperFindBottomLeftValue(root.left, level+1);
            int[] t2 = helperFindBottomLeftValue(root.right, level+1);
            res = t1[1] >= t2[1] ? t1:t2;
        }
        return res;
    }

    //84.91%
    public int findLUSlength(String a, String b) {
        if(a.length() == 0 && b.length() == 0) {
            return -1;
        } else if (a.length() != b.length()){
            return Math.max(a.length(), b.length());
        } else {
            if (!a.equals(b)) {
                return a.length();
            } else {
                return -1;
            }
        }
    }

    //10.32%
    public int getMinimumDifference(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        helperGetMinimumDifference(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i+1)));
        }
        return min;
    }
    //中序遍历拿到有序数组，求相邻元素的差的最小值.
    private void helperGetMinimumDifference(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        helperGetMinimumDifference(root.left, list);
        list.add(root.val);
        helperGetMinimumDifference(root.right, list);
    }

    //4.36%
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        Stack<Character> front = new Stack<>();
        Queue<Character> after = new LinkedList<>();
        int group = chars.length / (2*k);
        int left = chars.length % (2*k);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < group; i++) {
            for (int j = i*2*k; j < (i+1)*2*k; j++) {
                if (j % (2*k) < k) {
                    front.push(chars[j]);
                } else {
                    after.add(chars[j]);
                }
            }
            while(!front.isEmpty()) {
                sb.append(front.pop());
            }
            while (!after.isEmpty()) {
                sb.append(after.poll());
            }
        }
        if (left > 0) {
            for (int i = 0; i < left; i++) {
                if (i < k) {
                    front.push(chars[2*k*group + i]);
                } else {
                    after.add(chars[2*k*group + i]);
                }
            }
            while(!front.isEmpty()) {
                sb.append(front.pop());
            }
            while (!after.isEmpty()) {
                sb.append(after.poll());
            }
        }
        return sb.toString();
    }

    // 60.95%
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return helperMaxDepth(root, 0);
    }
    private int helperMaxDepth(Node root, int curDep) {
        if (root == null || root.children == null || root.children.size() == 0) {
            return curDep;
        }
        for (Node node : root.children) {
            curDep = Math.max(curDep+1, helperMaxDepth(node, curDep+1));
        }
        return curDep;
    }


    // 16.76%
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i % 2 == 0) {
//                res += nums[i];
//            }
//        }
        // 82.73%
        boolean odd = true;
        for (int i = 0; i < nums.length; i++) {
            if (odd) {
                res += nums[i];
            }
            odd = !odd;
        }
        return res;
    }

    //39.55%
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeHelper2(root, 0);
    }

    private int diameterOfBinaryTreeHelper2(TreeNode root, int dep) {
        if (root == null) {
            return dep;
        }
        int left = diameterOfBinaryTreeHelper(root.left, 0);
        int right = diameterOfBinaryTreeHelper(root.right, 0);
        dep = Math.max(dep, left + right);
        int temp = Math.max(diameterOfBinaryTreeHelper2(root.left, dep),diameterOfBinaryTreeHelper2(root.right, dep));
        return Math.max(dep, temp);
    }

    private int diameterOfBinaryTreeHelper(TreeNode root, int dep) {
        if (root == null) {
            return dep;
        }
        dep += 1;
        int temp = Math.max(diameterOfBinaryTreeHelper(root.left, dep), diameterOfBinaryTreeHelper(root.right, dep));
        return Math.max(dep, temp);
    }

    // 10.61%
    private HashMap<Integer, Integer> resultOfFindFrequentTreeSum = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        helperFindFrequentTreeSum(root);
        Set<Integer> integers = resultOfFindFrequentTreeSum.keySet();
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int t : integers) {
            Integer value = resultOfFindFrequentTreeSum.get(t);
            if (value > max) {
                res.clear();
                res.add(t);
                max = value;
            } else if (value == max) {
                res.add(t);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    private int helperFindFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        if (root.left != null) {
            sum += helperFindFrequentTreeSum(root.left);
        }
        if (root.right != null) {
            sum += helperFindFrequentTreeSum(root.right);
        }
        resultOfFindFrequentTreeSum.put(sum, resultOfFindFrequentTreeSum.getOrDefault(sum, 0) + 1);
        return sum;
    }


    // 20.87%
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValuesList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            int max = Integer.MIN_VALUE;
            while (i++ < size) {
                TreeNode poll = queue.poll();
                if (poll.val > max) {
                    max = poll.val;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            largestValuesList.add(max);
        }

        return  largestValuesList;

    }

    // 98.77%
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int aTime = 0;
        int hasLateOne = 0;
        for (char c : arr) {
            if (c == 'A') {
                aTime++;
                if (aTime > 1) {
                    return false;
                }
                hasLateOne = 0;
            } else if(c == 'L') {
                hasLateOne++;
                if(hasLateOne > 2) {
                    return false;
                }
            } else {
                hasLateOne = 0;
            }
        }
        return true;
    }

    // 99.70%
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int r1 = nums[0].length * nums.length;
        int r2 = r * c;
        if (r1 != r2) {
            return nums;
        }
        int[][] res = new int[r][c];
        int a1 = 0;
        int a2 = 0;
        for (int i = 0; i < nums.length;i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (a2 >= c) {
                    a2 = 0;
                    a1++;
                }
                res[a1][a2++] = nums[i][j];
            }
        }
        return res;
    }

}