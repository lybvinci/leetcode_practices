package com.monster.learn;

import java.util.HashSet;

public class NumComponents {

    //84.58%
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        HashSet<Integer> containers = new HashSet<>();
        for(int num : nums) {
            containers.add(num);
        }

        ListNode cur = head;

        while (cur != null) {
            if (containers.contains(cur.val) && (cur.next == null || !containers.contains(cur.next.val))) {
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    } 
}
