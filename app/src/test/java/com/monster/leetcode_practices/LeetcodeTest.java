package com.monster.leetcode_practices;

import android.util.ArraySet;
import android.util.SparseArray;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;


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
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(2);
//
//        root.left = left;
//        root.right = right;
//        findFrequentTreeSum(root);
//        checkRecord("PPALLL");
//        distributeCandies(new int[]{1,1,2,3});
//        findUnsortedSubarray(new int[]{3, 2, 3, 24});
//        reverseWords("s    s");
//        findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
//                new String[]{"KFC","Burger King","Tapioca Express","Shogun"});
//        checkPossibility(new int[]{2,3,3,2,4});
//        trimBST(root, 1,2);
//        calPoints(new String[]{"5","2","C","D","+"});
//        repeatedStringMatch("abc", "cabcabca");
//        hasAlternatingBits(5);
//        search(new int[]{5}, 5);
//        rotatedDigits(11);
//        isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}});
//        mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
//        numMagicSquaresInside(new int[][]{{3,10,2,3,4},{4,5,6,8,1},{8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}});
//        reverseOnlyLetters("ab-dc");
        largestTimeFromDigits(new int[]{0,0,0,0});
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
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // 79.87%
    class MyQueue {

        private Stack<Integer> mStack1;
        private Stack<Integer> mStack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            mStack1 = new Stack<>();
            mStack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                mStack1.push(x);
            } else if (mStack1.isEmpty()) {
                int size = mStack2.size();
                for (int i = 0; i < size; i++) {
                    mStack1.push(mStack2.pop());
                }
                mStack1.push(x);
            } else {
                mStack1.push(x);
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                return 0;
            } else if (mStack1.isEmpty()) {
                return mStack2.pop();
            } else {
                int size = mStack1.size() - 1;
                for (int i = 0; i < size; i++) {
                    mStack2.push(mStack1.pop());
                }
                return mStack1.pop();
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (mStack1.isEmpty() && mStack2.isEmpty()) {
                return 0;
            } else if (mStack1.isEmpty()) {
                return mStack2.peek();
            } else {
                int size = mStack1.size();
                for (int i = 0; i < size; i++) {
                    mStack2.push(mStack1.pop());
                }
                return mStack2.peek();
            }
        }

        /**
         * Returns whether the queue is empty.
         */
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
            if (nums == null || nums.length == 0) {
                return;
            }

        }

        public int sumRange(int i, int j) {
            if (sums == null) {
                this.sums = new int[nums.length];
                this.sums[0] = nums[0];
                for (int k = 1; k < nums.length; k++) {
                    sums[k] = sums[k - 1] + nums[k];
                }
            }

            if (i <= 0) {
                return sums[j];
            } else {
                return nums[i] + (sums[j] - sums[i]);
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
            for (int i = 0; i < parLength; i++) {
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
            nums[index++] = 0;
        }
    }

    //46.13%
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pos = head;
        while (pos != null) {
            list.add(pos.val);
            pos = pos.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
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
                (root.val < p.val && root.val > q.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
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
        if (t.length() != s.length()) {
            return false;
        }
        int[] times = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            times[sc[i] - 'a']++;
            times[tc[i] - 'a']--;
        }
        for (int i = 0; i < times.length; i++) {
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
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
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
        if (n >= 0) {
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
        boolean[] b = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            b[nums[i]] = true;
        }
        for (int i = 0; i < b.length; i++) {
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
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // for test
    private boolean isBadVersion(int n) {
        return n == 4;
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int left = n % 10;
        if (left != 3 && left != 9 && left != 7 && left != 1) {
            return false;
        }
        int sum = 0;
        int tmp = n;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum % 3 != 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;

    }

    // 11.20%
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
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
            num /= 4;
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
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> result = new HashSet<>();
        List<Integer> nums2L = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2L.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
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
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> nums2L = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2L.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
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
            temp = start * start;
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

    private int guess(int n) {
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
        for (int i = 0; i < rC.length; i++) {
            int j = 0;
            for (; j < mC.length; j++) {
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
        for (int i = 0; i < chars.length; i++) {
            int index = s.indexOf(chars[i], i + 1);
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
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }
        res[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                return (char) ('a' + i);
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
            builder.append((char) (carry % 10 + '0'));
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
        for (int i = 0; i < chars.length; i++) {
            int num = 1;
            int j = i + 1;
            for (; j < chars.length; j++) {
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
                while (num > 0) {
                    stack.push(num % 10);
                    num /= 10;
                }
                while (!stack.isEmpty()) {
                    chars[index++] = (char) (stack.pop() + '0');
                }
                i = j - 1;
            }
        }
        return index;
    }

    //74.37%
    public int arrangeCoins(int n) {
        long t = (long) n;
        return (int) (Math.sqrt(1 + 8 * t) - 1) / 2;
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
                t[s.charAt(i + j) - 'a']++;
                t[p.charAt(j) - 'a']--;
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
        for (int i = 1; i <= n; i++) {
            d3 = i % 3;
            d5 = i % 5;
            if (d3 == 0 && d5 == 0) {
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

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

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
        while (!temp.isEmpty()) {
            int size = temp.size();
            ArrayList<Integer> childList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
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
        for (int i = 0; i < nums.length; i++) {
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
        return third == Long.MIN_VALUE ? (int) first : (int) third;
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
        for (int i = 0; i < chars.length; i++) {
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
        return result * 2 < s.length() ? result * 2 + 1 : result * 2;
    }

    // 40.12%
    public int findNthDigit(int n) {
        int digitType = 1;
        long digitNum = 9;
        //定位到是几位数
        while (n > digitNum * digitType) {
            n -= (int) digitNum * digitType;
            digitType++;
            digitNum *= 10;
        }
        //定位到是这些几位数里面的第几个的第几位
        int indexInSubRange = (n - 1) / digitType;
        int indexInNum = (n - 1) % digitType;
        //还原数字
        int num = (int) Math.pow(10, digitType - 1) + indexInSubRange;
        int result = Integer.parseInt(("" + num).charAt(indexInNum) + "");
        return result;
    }

    //56.78%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
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
            for (int i = 1; i < nums.length; i++) {
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
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
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
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) continue;
            String refer = s.substring(0, i);
            int a = 1;
            for (int j = i; j < n; j = j + i) {
                String tmp = s.substring(j, j + i);
                if (!refer.equals(tmp)) {
                    a = 0;
                    break;
                }
            }
            if (a == 1) return true;
        }
        return false;
    }

    //19.24%
    public int hammingDistance(int x, int y) {
        int sum = 0;
        int temp = x ^ y;
        while (temp > 0) {
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
        return num ^ (mask - 1);
    }

    // 34.78%
    public String licenseKeyFormatting(String S, int K) {
        String no_S = S.replaceAll("-", "");
        int segNum = (no_S.length() - 1) / K;
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
        int sqrt = (int) Math.floor(Math.sqrt(area));
        for (int i = sqrt; i <= area; i++) {
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
        boolean flag = num >= 0;
        long temp = num;
        temp = Math.abs(temp);
        while (temp >= 7) {
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
            add('q');
            add('w');
            add('e');
            add('r');
            add('t');
            add('y');
            add('u');
            add('i');
            add('o');
            add('p');
        }
    };
    Set<Character> second = new HashSet<Character>() {
        {
            add('a');
            add('s');
            add('d');
            add('f');
            add('g');
            add('h');
            add('j');
            add('k');
            add('l');
        }
    };
    Set<Character> third = new HashSet<Character>() {
        {
            add('z');
            add('x');
            add('c');
            add('v');
            add('b');
            add('n');
            add('m');
        }
    };

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
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

            for (int j = 1; j < chars.length; j++) {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        helperFindMode(root, map);
        Set<Integer> keys = new HashSet<>();
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
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
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
            } else if (firstIsUpper && !secondIsUpper) {
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
        return helperFindBottomLeftValue(root, 0)[0];
    }

    private int[] helperFindBottomLeftValue(TreeNode root, int level) {
        int[] res;
        if (root.left == null && root.right == null) {
            return new int[]{root.val, level};
        } else if (root.left == null) {
            res = helperFindBottomLeftValue(root.right, level + 1);
        } else if (root.right == null) {
            res = helperFindBottomLeftValue(root.left, level + 1);
        } else {
            int[] t1 = helperFindBottomLeftValue(root.left, level + 1);
            int[] t2 = helperFindBottomLeftValue(root.right, level + 1);
            res = t1[1] >= t2[1] ? t1 : t2;
        }
        return res;
    }

    //84.91%
    public int findLUSlength(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return -1;
        } else if (a.length() != b.length()) {
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
            min = Math.min(min, Math.abs(list.get(i) - list.get(i + 1)));
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
        int group = chars.length / (2 * k);
        int left = chars.length % (2 * k);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < group; i++) {
            for (int j = i * 2 * k; j < (i + 1) * 2 * k; j++) {
                if (j % (2 * k) < k) {
                    front.push(chars[j]);
                } else {
                    after.add(chars[j]);
                }
            }
            while (!front.isEmpty()) {
                sb.append(front.pop());
            }
            while (!after.isEmpty()) {
                sb.append(after.poll());
            }
        }
        if (left > 0) {
            for (int i = 0; i < left; i++) {
                if (i < k) {
                    front.push(chars[2 * k * group + i]);
                } else {
                    after.add(chars[2 * k * group + i]);
                }
            }
            while (!front.isEmpty()) {
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
            curDep = Math.max(curDep + 1, helperMaxDepth(node, curDep + 1));
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
        int temp = Math.max(diameterOfBinaryTreeHelper2(root.left, dep), diameterOfBinaryTreeHelper2(root.right, dep));
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

        return largestValuesList;

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
            } else if (c == 'L') {
                hasLateOne++;
                if (hasLateOne > 2) {
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
        for (int i = 0; i < nums.length; i++) {
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

    //2.90%
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            container.put(candies[i], container.getOrDefault(candies[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(container.values());
        list.sort((s1, s2) -> s2 - s1);
        int nums = candies.length / 2;
        int has = 0;
        int res = container.size();
        int i = 0;
        while (i < container.size() && list.get(i) > 1) {
            has += list.get(i++) - 1;
        }
        if (has < nums) {
            res -= nums - has;
        }
        return res;

        // 80%
//        Set<Integer> set = new HashSet<>();
//        for (int j : candies) {
//            set.add(j);
//        }
//        return Math.min(set.size(), candies.length /2 );

    }


    //39.42%
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        int i = 0, j = nums.length - 1;
        while (nums[i] == sortedArr[i] && i < j) i++;
        while (nums[j] == sortedArr[j] && i < j) j--;
        if (i == j) return 0;
        else return j - i + 1;
    }

    //23.02%
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder(s.length());
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.append(chars[i]);
            } else {
                stack.push(chars[i]);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    // 87.26%
    int findTiltRes = 0;
    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return findTiltRes;
    }

    private int findTiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);
        findTiltRes += Math.abs(left - right);
        return left + right + root.val;
    }

    //72.48%
    private List<Integer> preorderList = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preorderHelper(root);
        return preorderList;
    }
    private void preorderHelper(Node root) {
        if (root == null) {
            return;
        }
        preorderList.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            preorderHelper(node);
        }
    }

    //99.13%
    private List<Integer> postorderList = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        postorderHelper(root);
        return postorderList;
    }
    private void postorderHelper(Node root) {
        if (root == null) {
            return;
        }
        if (root.children == null) {
            postorderList.add(root.val);
            return;
        }
        for (Node node : root.children) {
            postorderHelper(node);
        }
        postorderList.add(root.val);
    }

    // 71.68%
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length <= 0) {
            return m*n;
        }
        int a = ops[0][0];
        int b = ops[0][1];
        for (int i = 0; i < ops.length; i++) {
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a*b;
    }

    //30.42%
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i < list1.length ;i++) {
            map.put(list1[i], i);
        }
        Set<String> res = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length;i++) {
            if (map.containsKey(list2[i])) {
                int value = map.get(list2[i]) + i;
                if (value < min) {
                    min = value;
                    res.clear();
                    res.add(list2[i]);
                } else if (value == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    //97.47%
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1)
            return flowerbed[0] == 0 || n == 0;
        if (flowerbed.length == 2)
            return n == 0 || (flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1);
        int len = flowerbed.length;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            n--;
        }

        for (int i = 1; i < len - 1; ++i)
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        return n <= 0;

    }

    // 94.43%
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        tree2strSb.deleteCharAt(0);
        tree2strSb.deleteCharAt(tree2strSb.length() - 1);
        return tree2strSb.toString();
    }
    private StringBuilder tree2strSb = new StringBuilder();

    private void tree2strHelper(TreeNode t) {
        if (t == null) {
            return;
        }
        tree2strSb.append("(" + t.val);
        if (t.left != null) {
            tree2strHelper(t.left);
        } else if (t.left == null && t.right != null){
            tree2strSb.append("()");
        }
        if (t.right != null) {
            tree2strHelper(t.right);
        }
        tree2strSb.append(")");
    }

    // 59.45%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeTreesHelper(t1, t2);
    }

    private TreeNode mergeTreesHelper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2!= null) {
            t1.val += t2.val;
            t1.left = mergeTreesHelper(t1.left, t2.left);
            t1.right = mergeTreesHelper(t1.right, t2.right);
            return t1;
        } else if (t1 == null) {
            return t2;
        } else {
            return t1;
        }
    }

    //19.84%
    public int maximumProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        } else if (nums.length <= 3) {
            int res = nums[0];
            for (int i = 1; i < nums.length;i++) {
                res *= nums[i];
            }
            return res;
        } else {
            Arrays.sort(nums);
            int res = nums[nums.length-1];
            int pre = nums[0] * nums[1];
            int last = nums[nums.length - 2] * nums[nums.length - 3];
            res *= pre > last ? pre : last;
            return res;
        }
    }

    //32.06%
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c) + 1;
        int a = 0;
        int b = 0;
        for (int i = 0; i <= max; i++) {
            a = i * i;
            if (a > c) {
                return false;
            } else if (a == c) {
                return true;
            } else {
                if (Math.sqrt(c-a) % 1.0 == 0){
                    return true;
                }
            }
        }
        return false;
    }

    //69.27%
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(sum/(double)size);
        }
        return res;
    }

    //61.49%
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k && i < nums.length; i++) {
            sum += nums[i];
        }
        long sumBak = sum;
        if (nums.length > k) {
            for (int j = k; j < nums.length; j++) {
                sumBak = sumBak - nums[j - k] + nums[j];
                sum = Math.max(sum, sumBak);
            }
        }
        return sum / (double)k;
    }

    // 77.71%
    public int[] findErrorNums(int[] nums) {
        int[] ns = new int[nums.length+1];
        int[] res = new int[2];
        for (int i = 0 ; i < nums.length; i++) {
            ns[nums[i]]++;
        }
        boolean hasSet = false;
        boolean hasSet2 = false;
        for (int i = 1; i < ns.length;i++) {
            if (ns[i] > 1) {
                res[0] = i;
                hasSet = true;
            }
            if (ns[i] == 0) {
                res[1] = i;
                hasSet2 = true;
            }
            if (hasSet && hasSet2) {
                break;
            }
        }
        return res;

    }

    //97.25%
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int[] container = new int[]{0,0}; // LR UD
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'L':
                    container[0]++;
                    break;
                case 'R':
                    container[0]--;
                    break;
                case 'U':
                    container[1]++;
                    break;
                case 'D':
                    container[1]--;
                    break;
            }
        }
        return container[0] == 0 && container[1] == 0;
    }

    //10.26%
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length;j++) {
                int sum = 0;
                int num = 0;
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) {
                        sum += M[i-1][j-1];
                        num++;
                    }
                    sum += M[i-1][j];
                    num++;
                    if (j + 1 < M[0].length) {
                        sum += M[i-1][j+1];
                        num++;
                    }
                }
                sum += M[i][j];
                num++;
                if (j -1 >= 0) {
                    sum += M[i][j-1];
                    num++;
                }
                if (j + 1 < M[0].length) {
                    sum += M[i][j+1];
                    num++;
                }
                if (i + 1 < M.length) {
                    if (j -1 >= 0) {
                        sum += M[i+1][j-1];
                        num++;
                    }
                    sum += M[i+1][j];
                    num++;
                    if (j + 1 < M[0].length) {
                        sum += M[i+1][j+1];
                        num++;
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;
    }

    //56.32%
    public boolean checkPossibility(int[] nums) {
        int i = 0,j = nums.length - 1;
        while(i < j && nums[i] <= nums[i + 1])
            i++;
        while(i < j && nums[j] >= nums[j - 1])
            j--;
        int head = 0;
        if(i == 0)
            head = Integer.MIN_VALUE;
        else
            head = nums[i - 1];
        int next = (j==nums.length - 1)?Integer.MAX_VALUE:nums[j + 1];
        if(j - i <= 1 && (head <= nums[j] || nums[i] <= next))
            return true;
        else
            return false;
    }

    //66.39%
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (null == root) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;

    }

    // 100%
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return -1;
        int leftV = root.left.val;//
        int rightV = root.right.val;//
        if((root.val == root.left.val))
            leftV =  findSecondMinimumValue(root.left);
        else
            leftV = root.left.val;

        if(root.val == root.right.val)
            rightV = findSecondMinimumValue(root.right);
        else
            rightV = root.right.val;
        if(leftV != -1 && rightV != -1)
            return Math.min(leftV,rightV);
        if(leftV == -1)
            return rightV;
        if(rightV == -1)
            return leftV;
        return -1;
    }

    //81.26%
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int max = 0;
        boolean is = true;
        int temp = 1;
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] > nums[i-1]) {
                if (is) {
                    temp++;
                } else {
                    temp = 2;
                    is = true;
                }
            } else {
                is = false;
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max, temp);
        return max;
    }

    // 91.80%
    public int calPoints(String[] ops) {
        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0 ; i < ops.length ;i++) {
            if ("C".equals(ops[i])) {
                list.pollLast();
            } else if ("+".equals(ops[i])) {
                list.addLast(list.get(list.size() - 2) + list.getLast());
            } else if ("D".equals(ops[i])) {
                list.addLast(list.getLast() * 2);
            } else {
                list.addLast(Integer.parseInt(ops[i]));
            }
        }
        for (Integer i : list) {
            res += i;
        }
        return res;
    }

    //9.30%
    public int repeatedStringMatch(String A, String B) {
        if (A.contains(B)) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < B.length() / A.length() + 2;i++) {
            sb.append(A);
            if (sb.indexOf(B) != -1) {
                return i+2;
            }
        }
        return -1;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    //73.89%
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> mp = new HashMap<>();
        for (int i = 0; i < employees.size();i++) {
            mp.put(employees.get(i).id, employees.get(i));
        }
        List<Integer> sub = null;
        int res = 0;
        Employee employee = mp.get(id);
        res += employee.importance;
        sub = employee.subordinates;
        while (sub != null && sub.size() > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i : sub) {
                employee = mp.get(i);
                res += employee.importance;
                if (employee.subordinates != null && employee.subordinates.size() > 0) {
                    list.addAll(employee.subordinates);
                }
            }
            sub = list;
        }
        return res;
    }

    //67.73%
    public boolean hasAlternatingBits(int n) {
        int start = n & 0x01;
        while (n > 0) {
            n >>= 1;
            if (start == (n & 0x01)) {
                return false;
            }
            start = n & 0x01;
        }
        return true;
    }

    //36.30%
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length;i++) {
            for (int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res,maxAreaOfIslandHelper(grid, i, j));
                }
            }
        }
        return res;
    }
    private int maxAreaOfIslandHelper(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1)  {
            grid[i][j] = 0;
            int num = 1 + maxAreaOfIslandHelper(grid,i-1,j) + maxAreaOfIslandHelper(grid,i+1,j)
                    + maxAreaOfIslandHelper(grid,i,j-1) + maxAreaOfIslandHelper(grid, i, j+1);
            return num;
        } else {
            return 0;
        }
    }


    //53.72%
    public int findShortestSubArray(int[] nums) {
        Set<Integer> des = new HashSet<>();
        int time = 0;
        Map<Integer,Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            res.put(nums[i],res.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : res.keySet()) {
            Integer value = res.get(key);
            if (value > time) {
                des.clear();
                des.add(key);
                time = value;
            } else if (value == time) {
                des.add(key);
            }
        }
        int result = nums.length;
        for (Integer i : des) {
            int start = 0;
            int end = nums.length;
            for (int j = 0; j < nums.length;j++) {
                if (nums[j] == i) {
                    start = j;
                    break;
                }
            }
            for (int j = nums.length - 1; j >=start;j--) {
                if (nums[j] == i) {
                    end = j;
                    break;
                }
            }
            result = Math.min(result, end - start + 1);
        }
        return result;
    }

    //100.00%
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    //19.13%
    public int search(int[] nums, int target) {
        if (nums[nums.length-1] < target) {
            return -1;
        }
        for (int i = 0; i < nums.length;i++) {
            if (target < nums[i]) {
                return -1;
            } else if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    //58.31%
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++ ) {
            int temp = i;
            int t2 = 0;
            int j = 0;
            while (temp != 0) {
                int k = temp % 10;
                int rk = -1;
                switch (k){
                    case 1:rk = 1;break;
                    case 2:rk = 5;break;
                    case 5:rk = 2;break;
                    case 6:rk = 9;break;
                    case 8:rk = 8;break;
                    case 9:rk = 6;break;
                    default:rk = -1;
                }
                if (rk == -1) {
                    t2 = -1;
                    break;
                }
                t2 += rk * Math.pow(10,j);
                temp /= 10;
                j++;
            }
            if (t2 == -1 || t2 == i) {
                continue;
            }
            res++;

        }
        return res;
    }

    //50.11%
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        letterCasePermutationHelper("", S, res, 0);
        return res;
    }

    public void letterCasePermutationHelper(String pre, String S, List<String> res, int index) {
        if (pre.length() == S.length()) {
            res.add(pre);
            return;
        }
        char ch = S.charAt(index);
        if (!Character.isLetter(ch)) {
            letterCasePermutationHelper(pre + ch, S, res, index+1);
        } else {
            ch = Character.toLowerCase(ch);
            letterCasePermutationHelper(pre + ch, S, res, index + 1);
            ch = Character.toUpperCase(ch);
            letterCasePermutationHelper(pre + ch, S, res, index+1);
        }
    }

    //50.92%
    public int numJewelsInStones(String J, String S) {
        int[] res = new int[58];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if (J.contains(chars[i] + "")) {
                res[chars[i] - 'a']++;
            }
        }
        int result = 0;
        for (int i = 0; i < res.length;i++) {
            result += res[i];
        }
        return result;
    }

    //38.57%
    public int minDiffInBST(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        minDiffInBSTHelper(root, res);
        int[] result = new int[res.size() - 1];
        for (int i = 0; i < res.size() - 1;i++) {
            result[i] = res.get(i+1) - res.get(i);
        }
        Arrays.sort(result);
        return result[0];
    }

    public void minDiffInBSTHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        minDiffInBSTHelper(root.left, res);
        res.add(root.val);
        minDiffInBSTHelper(root.right, res);
    }

    //39%
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){        //遍历方阵
                if(i+1<matrix.length&&j+1<matrix[0].length&&matrix[i][j]!=matrix[i+1][j+1]){
                    return false;                       //只要某一个元素和对角线上的下一个元素不一致，那么返回false
                }
            }
        }
        return true;
    }

    //52.60%
    private static List<Integer> countPrimeSetBitsList = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37);
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = i;
            int num = 0;
            while (t > 0) {
                num += t & 0x01;
                t >>= 1;
            }
            if (countPrimeSetBitsList.contains(num)) {
                res++;
            }
        }
        return res;
    }

    //56.10%
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toLowerCase().toCharArray();
        int[] charsInts = new int[26];
        for (char s : chars) {
            if (Character.isLetter(s)) {
                charsInts[s - 'a']++;
            }
        }
        String res = "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < words.length;i++) {
            char[] charsWord = words[i].toLowerCase().toCharArray();
            int[] charsCopy = Arrays.copyOf(charsInts, charsInts.length);
            for (char s : charsWord) {
                charsCopy[s-'a']--;
            }
            boolean is = true;
            for (int j : charsCopy) {
                if (j > 0) {
                    is = false;
                    break;
                }
            }
            if (is) {
                if (words[i].length() < minLength) {
                    res = words[i];
                    minLength = words[i].length();
                }
            }
        }
        return res;
    }

    //72.32%
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        String temp = A + A;
        if (temp.contains(B)) {
            return true;
        }
        return false;
    }

    //96.58%
    String[] uniqueMorseRepresentationsPassword = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < words.length;i++) {
            char[] chars = words[i].toCharArray();
            String psd = "";
            for (char s : chars) {
                psd += uniqueMorseRepresentationsPassword[s - 'a'];
            }
            res.add(psd);
        }
        return res.size();
    }

    //66.50%
    public int[] numberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        int sum = 0;
        int[] res = new int[]{1,0};
        for (int i = 0; i < S.length(); i++) {
            int length = widths[chars[i] - 'a'];
            if (sum + length > 100) {
                res[0]++;
                sum = length;
            } else {
                sum += length;
            }
        }
        res[1] = sum;
        return res;
    }

    //90.89%
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Long> result = new HashMap<>();
        for (String s : cpdomains) {
            String[] split = s.split(" ");
            String[] net = split[1].split("\\.");
            String domain = "";
            for (int i = net.length - 1; i >=0 ; i--) {
                if (domain.length() == 0) {
                    domain = net[i];
                }else {
                    domain = net[i] + "." + domain;
                }
                result.put(domain, result.getOrDefault(domain,0L) + Long.parseLong(split[0]));
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : result.keySet()) {
            res.add(result.get(key) + " " + key);
        }
        return res;
    }

    //66.27%
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    area = Math.max(area, 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]));
                }
            }
        }
        return area;
    }

    //3.30%
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");
        List<String> bannedList = Arrays.asList(banned);
        HashMap<String,Integer> result = new HashMap<>();
        for (String s : words) {
            if (bannedList.contains(s)) {
                continue;
            }
            result.put(s, result.getOrDefault(s, 0)+1);
        }
        Optional<String> max = result.keySet().stream().max((key1, key2) -> result.get(key1) - result.get(key2));
        return max.get();

    }

    //91.63%
    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] index = new int[S.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                index[i] = 0;
                continue;
            }
            int r1 = Integer.MAX_VALUE;
            int index1 = 1;
            for (int j = i-1;j>=0;j--) {
                if (chars[j] == C) {
                    r1 = index1;
                    break;
                }
                index1++;
            }

            int r2 = Integer.MAX_VALUE;
            int index2 = 1;
            for (int j = i+1;j<chars.length;j++) {
                if (chars[j] == C) {
                    r2 = index2;
                    break;
                }
                index2++;
            }
            index[i] = Math.min(r1,r2);

        }
        return index;
    }

    //7.59%
    public String toGoatLatin(String S) {
        String[] split = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i <split.length; i++) {
            char startC = split[i].charAt(0);
            char c = Character.toLowerCase(startC);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(split[i]);
            } else if (split[i].length() < 1){
                sb.append(split[i]);
            } else {
                String t = split[i].substring(1, split[i].length()) + split[i].charAt(0);
                sb.append(t);
            }
            sb.append("ma").append(new String(new char[i+1]).replace("\0", "a")).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //95.77%
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S.length() < 3) {
            return result;
        }
        char[] chars = S.toCharArray();
        char a = chars[0];
        int num = 1;
        for (int i = 1; i < chars.length;i++) {
            if (chars[i] == a) {
                num++;
            } else {
                if (num >= 3) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i - num);
                    cell.add(i - 1);
                    result.add(cell);
                }
                a = chars[i];
                num = 1;
            }
        }
        if (num >= 3) {
            List<Integer> cell = new ArrayList<>();
            cell.add(chars.length - num);
            cell.add(chars.length  - 1);
            result.add(cell);
        }
        return result;
    }

    // 97.46%
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0 ; i < A.length;i++) {
            for (int j = A[i].length - 1; j >= 0 ;j--) {
                result[i][A[i].length - 1 - j] = A[i][j] == 1 ? 0: 1;
            }
        }
        return result;
    }

    //88.46%
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec2[2] > rec1[0] && rec2[0] < rec1[2] && rec2[3] > rec1[1] && rec2[1] < rec1[3];
    }

    //52.24%
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res=0;
        for(int i=0;i+2<n;i++) {
            for(int j=0;j+2<m;j++){
                res+=numMagicSquaresInsideJudge(i,j,grid);
            }
        }
        return res;
    }
    private int numMagicSquaresInsideJudge(int x,int y,int [][] g) {
        int[] a = new int[10];
        //判断是否是1-9的数据，是否唯一
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (g[i][j] >= 10 || g[i][j] <= 0) return 0;
                a[g[i][j]]++;
                if (a[g[i][j]] > 1) return 0;
            }
        }
        //每一行
        int sum = -1, tmp = 0;
        for (int i = x; i < x + 3; i++) {
            tmp = 0;
            for (int j = y; j < y + 3; j++) {
                tmp += g[i][j];
            }
            if (sum == -1) sum = tmp;
            else if (sum != tmp) return 0;
        }
        //每一列
        for (int j = y; j < y + 3; j++) {
            tmp = 0;
            for (int i = x; i < x + 3; i++) {
                tmp += g[i][j];
            }
            if (sum != tmp) return 0;
        }
        //主对角线
        tmp = g[x][y] + g[x + 1][y + 1] + g[x + 2][y + 2];
        if (sum != tmp) return 0;
        //副对角线
        tmp = g[x][y + 2] + g[x + 1][y + 1] + g[x + 2][y];
        if (sum != tmp) return 0;
        return 1;
    }

    //0.87%
    public boolean backspaceCompare(String S, String T) {
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();
        LinkedList<Character> l = new LinkedList<>();
        for (char s : sChar) {
            if (s == '#') {
                if (l.size() > 0) {
                    l.pop();
                }
            } else {
                l.push(s);
            }
        }
        String s1 = l.stream().map(c -> c.toString()).reduce("", (c1, c2) -> c1 + c2);
        l.clear();
        for (char s : tChar) {
            if (s == '#') {
                if (l.size() > 0) {
                    l.pop();
                }
            } else {
                l.push(s);
            }
        }
        String s2 = l.stream().map(c -> c.toString()).reduce("", (c1, c2) -> c1 + c2);
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }


    //4.26%
    public int maxDistToClosest(int[] seats) {
        LinkedList<Integer> has = new LinkedList<>();
        for (int i = 0; i < seats.length;i++) {
            if (seats[i] == 1) {
                has.add(i);
            }
        }
        int result = has.get(0);
        for (int i = 1; i < has.size();i++) {
            result = Math.max(result, (has.get(i) - has.get(i-1))/2);
        }
        result = Math.max(result, seats.length - 1 - has.getLast());
        return result;
    }

    //59.48%
    public int peakIndexInMountainArray(int[] A) {
       int index = 0;
       int max = Integer.MIN_VALUE;
       for (int i = 0; i < A.length ; i ++) {
           if (A[i] > max) {
               max = A[i];
               index = i;
           }
       }
       return index;
    }

    //62.22%
    public boolean buddyStrings(String A, String B) {
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        Set<Character> set=new HashSet<>();
        if(A.length()!=B.length()||A.length()<2||B.length()<2)
            return false;
        if(A.equals(B)){//若A与B相等且字符串内部有重复的字母，则返回true.
            for(int i=0;i<A.length();i++){
                if(set.contains(A.charAt(i)))
                    return true;
                else
                    set.add(A.charAt(i));
            }
            return false;
        }else{//A与B不相等，只能有两个字符不相等，用a,b String类保存两个不相等的字符
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)!=B.charAt(i)){
                    a.append(A.charAt(i));
                    b.append(B.charAt(i));
                }
                if(a.length()>2)//不相等的字符超过两个
                    return false;
            }
            if(a.length()==2&&a.charAt(0)==b.charAt(1)&&a.charAt(1)==b.charAt(0))
                return true;
            else
                return false;
        }
    }

    //11.36%
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length ;i++) {
            if (bills[i] == 5) {
                map.put(bills[i], map.getOrDefault(bills[i],0)+1);
            } else if (bills[i] == 10) {
                if (map.getOrDefault(5,0) > 0) {
                    map.put(bills[i], map.getOrDefault(bills[i],0)+1);
                    map.put(5, map.get(5) - 1);
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (map.getOrDefault(10, 0) > 0 && map.getOrDefault(5,0) > 0) {
                    map.put(10, map.get(10)-1);
                    map.put(5, map.get(5) - 1);
                    map.put(bills[i], map.getOrDefault(bills[i],0) + 1);
                } else if (map.getOrDefault(5,0) > 2) {
                    map.put(5, map.get(5) - 3);
                    map.put(bills[i], map.getOrDefault(bills[i],0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //51.99%
    public int binaryGap(int N) {
        int res;
        List<Integer> a = new LinkedList<>();
        for (int i = 0; i <= 30; i++)
            if (((1 << i)&N) != 0) a.add(i);
        res = 0;
        for (int i = 0; i + 1<a.size(); i++)
            if (a.get(i+1) - a.get(i)>res) res = a.get(i + 1) - a.get(i);
        return res;
    }

    //35.96%
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new LinkedList<>();
        List<Integer> res2 = new LinkedList<>();
        leafSimilarHelper(root1, res1);
        leafSimilarHelper(root2, res2);
        if (res1.size() != res2.size()) {
            return false;
        } else {
            for (int i = 0; i < res1.size() ;i++) {
                if (res1.get(i) != res2.get(i)) {
                    return false;
                }
            }
            return true;
        }

    }

    private void leafSimilarHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            leafSimilarHelper(root.left, res);
            leafSimilarHelper(root.right, res);
        } else {
            res.add(root.val);
        }
    }

    //100.00%
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }
        return slow;
    }

    //57.58%
    public int projectionArea(int[][] grid) {
        int row=grid.length;
        int result=0;
        for(int i=0;i<row;i++){
            int maxa=grid[i][0];
            int maxb=grid[0][i];
            for(int j=0;j<row;j++){
                //俯视面积
                if(grid[i][j]!=0)
                    result++;
                //正侧两面
                maxa=Math.max(grid[i][j],maxa);
                maxb=Math.max(maxb,grid[j][i]);
            }
            result+=maxa+maxb;
        }
        return result;

    }

    //2.67%
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> times = new HashMap<>();
        for (String s : a) {
            times.put(s, times.getOrDefault(s,0)+1);
        }
        for (String s : b) {
            times.put(s, times.getOrDefault(s,0)+1);
        }
        List<String> res = new ArrayList<>();
        return times.keySet().stream().filter(s -> times.get(s) == 1).toArray(String[]::new);
    }

    //2.66%
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        //获取双方糖果的总大小
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            for (int j = 0; j < B.length; j++) {
                int b = B[j];
                //计算交换糖果后糖果的总大小
                int tmpA = sumA - a + b;
                int tmpB = sumB - b + a;
                if (tmpA == tmpB) {//判断交换后是否一致
                    result[0] = a;
                    result[1] = b;
                    break;
                }
            }

        }
        return result;
    }

    //72.77%
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        boolean isUp = true;
        int i = 1;
        while (i < A.length && A[0] == A[i]) {
            i++;
        }
        if (i == A.length) {
            return true;
        }
        if (A[i] < A[0]) {
            isUp = false;
        }
        for (int j = i+1; j < A.length ; j++) {
            if (A[j] == A[j-1]) {
                continue;
            }
            if (A[j] > A[j-1] && !isUp) {
                return false;
            }
            if (A[j] < A[j-1] && isUp) {
                return false;
            }
        }
        return true;
    }

    //52.21%
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        increasingBSTHelper(root, res);
        TreeNode result = new TreeNode(res.get(0));
        TreeNode currentNode = result;
        for (int i = 1; i < res.size(); i++) {
            currentNode.right = new TreeNode(res.get(i));
            currentNode = currentNode.right;
        }
        return result;
    }

    private void increasingBSTHelper(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            increasingBSTHelper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            increasingBSTHelper(root.right, list);
        }
    }

    //86.52%
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i : A) {
            if (i % 2 == 0) {
                res[start++] = i;
            } else {
                res[end--] = i;
            }
        }
        return res;
    }

    //40.33%
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int small = A[0] + Math.abs(K);
        int big = A[A.length - 1] - Math.abs(K);
        if (big > small) {
            return big - small;
        } else {
            return 0;
        }
    }

    //42.32%
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0; i < chars.length;i++) {
            if (!Character.isLetter(chars[i])) {
                res[i] = chars[i];
            }
        }
        int j = 0;
        for (int i = chars.length-1 ; i >=0 ; i--) {
            if (Character.isLetter(chars[i])) {
                while (res[j] != 0) {
                    j++;
                }
                res[j] = chars[i];
            }
        }
        return new String(res);

    }

    //40.29%
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i : deck) map.put(i,map.getOrDefault(i,0) + 1);
        for (int i :map.values()) res = hasGroupsSizeXHelper(i,res);
        return res > 1;
    }


    private static int hasGroupsSizeXHelper(int a,int b) {
        return b > 0 ? hasGroupsSizeXHelper(b, a % b) : a;
    }


    //14.34%
    public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        for (int i = 0; i < A.length ;i ++) {
            if (A[i] % 2 == 0) {
                two.push(A[i]);
            } else {
                one.push(A[i]);
            }
        }
        for (int i = 0; i < A.length;i++) {
            if (i % 2 == 0) {
                A[i] = two.pop();
            } else {
                A[i] = one.pop();
            }
        }
        return A;

    }

    //71.00%
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int j = 0;
        for (int i = 0; i < names.length ; i++) {
            if (j >= typeds.length) {
                return false;
            }
            if (names[i] == typeds[j]) {
                j++;
                continue;
            } else if (j-1 >=0 && typeds[j] == typeds[j-1]) {
                j++;
                i--;
            } else {
                return false;
            }
        }
        if (j == typeds.length) {
            return true;
        }
        for (int i = j; i < typeds.length;i++) {
            if (typeds[j-1] != typeds[i]) {
                return false;
            }
        }
        return true;
    }

    //20.99%
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length;i++) {
            String[] split = emails[i].split("@");
            int i1 = split[0].indexOf("+");
            if (i1 != -1) {
                split[0] = split[0].substring(0, i1);
            }
            split[0] = split[0].replaceAll(".","");
            set.add(split[0]+"@"+split[1]);
        }
        return set.size();
    }

    //50.93%
    class RecentCounter {
        private Queue<Integer> mQueue;

        public RecentCounter() {
            mQueue = new ArrayDeque<>();
        }

        public int ping(int t) {
            mQueue.add(t);
            while (t - mQueue.peek() > 3000) {
                mQueue.poll();
            }
            return mQueue.size();
        }
    }

    // 71.29%
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs=new LinkedList<>();
        List<String> digitLogs=new LinkedList<>();
        //日志分组
        for(String log:logs){
            char c=log.charAt(log.indexOf(" ")+1);
            if(c>=48 && c<=57){//是否包含数字
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }
        //字母日志排序
        letterLogs.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {//只比较日志内容
                String log1=o1.substring(o1.indexOf(" "));
                String log2=o2.substring(o2.indexOf(" "));
                return log1.compareTo(log2);
            }
        });
        //聚合日志
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(logs);
    }

    //46.72%
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        boolean shouldBigger = false;
        boolean shouldSmaller = false;
        for (int i = 1; i < A.length ;i++) {
            if (shouldSmaller) {
                if (A[i] >= A[i-1]) {
                    return false;
                }
            } else if (A[i] < A[i-1]) {
                if (!shouldBigger) {
                    return false;
                }
                shouldSmaller = true;
            } else if (A[i] == A[i-1]){
                return false;
            } else {
                shouldBigger = true;
            }
        }
        return shouldSmaller;
    }

    //72.06%
    public int[] diStringMatch(String S) {
        int min = 0;
        int max = S.length();
        int[] res = new int[S.length() + 1];
        char[] chars = S.toCharArray();
        for (int i = 0 ;i < chars.length; i++) {
            if (chars[i] == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[S.length()] = max;
        return res;
    }

    //89.26%
    public int minDeletionSize(String[] A) {
        int len = A[0].length();
        if(len < 2) return 0;

        int res = 0;
        int k = A.length;
        char[][] ch = new char[k][len];
        for(int i = 0; i < k; i++){
            ch[i] = A[i].toCharArray();
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; j < k - 1; j++){
                if(ch[j][i] > ch[j+1][i]){
                    res++;
                    break;
                }
            }
        }


        return res;
    }

    //71.25%
    public boolean isAlienSorted(String[] words, String order) {
        //构建新的字典序
        char[] dictionary=order.toCharArray();
        Map<Character,Integer> dictionaryOrder=new HashMap<>();
        for(int i=0;i<dictionary.length;i++){
            dictionaryOrder.put(dictionary[i],i);
        }
        //是否有序
        boolean isOrder=true;
        for(int j=0;j<words.length-1;j++){
            char[] word1=words[j].toCharArray();
            char[] word2=words[j+1].toCharArray();
            //遍历字符数组的次数
            int times=word1.length>word2.length?word1.length:word2.length;
            for(int k=0;k<times;k++){
                //获取需要比较的字符的字典序
                int c1=k<word1.length?dictionaryOrder.get(word1[k]):-1;
                int c2=k<word2.length?dictionaryOrder.get(word2[k]):-1;
                if(c1==c2){//字典序一致则比较下一个字符
                    continue;
                }else if(c1<c2){//前一个单词的字符字典序小于后一个单词的字符，则意味着满足字典序
                    break;
                }else{//前一个单词的字符字典序大于后一个单词的字符，则意味着不满足字典序，中断循环
                    isOrder=false;
                    break;
                }
            }
            if(!isOrder){//已确定不满足新字典序，中断循环
                break;
            }
        }
        return isOrder;
    }

    //
    String largestTimeFromDigitsAns;
    public String largestTimeFromDigits(int[] A) {
        largestTimeFromDigitsAns = "";
        largestTimeFromDigitsCheck(A[0], A[1], A[2], A[3]);
        largestTimeFromDigitsCheck(A[0], A[2], A[1], A[3]);
        largestTimeFromDigitsCheck(A[0], A[3], A[1], A[2]);
        largestTimeFromDigitsCheck(A[1], A[2], A[0], A[3]);
        largestTimeFromDigitsCheck(A[1], A[3], A[0], A[2]);
        largestTimeFromDigitsCheck(A[2], A[3], A[0], A[1]);

        return largestTimeFromDigitsAns;
    }

    private void largestTimeFromDigitsCheck(int h1, int h2, int m1, int m2) {
        String hour = largestTimeFromDigitsBest(h1, h2, 24);
        String minute = largestTimeFromDigitsBest(m1, m2, 60);
        if (hour.isEmpty() || minute.isEmpty()) return;

        String cand = hour + ":" + minute;
        if (cand.compareTo(ans) > 0) ans = cand;
    }

    private String largestTimeFromDigitsBest(int d1, int d2, int limit) {
        int ans = Math.max(10*d1 + d2 < limit ? 10*d1 + d2 : -1,
                10*d2 + d1 < limit ? 10*d2 + d1 : -1);
        return ans >= 0 ? String.format("%02d", ans) : "";
    }

    //15.39%
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length;i++) {
            int time = map.getOrDefault(A[i], 0);
            if (++time >= A.length/2) {
                return A[i];
            }
            map.put(A[i], time);
        }
        Set<Integer> integers = map.keySet();
        for (Integer key : integers) {
            if (map.get(key) >= A.length/2) {
                return key;
            }
        }
        return 0;
    }

    //73.48%
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTreeHelper(root, root.val);
    }

    public boolean isUnivalTreeHelper(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val == value) {
            return isUnivalTreeHelper(root.left, value) && isUnivalTreeHelper(root.right, value);
        } else {
            return false;
        }
    }





}