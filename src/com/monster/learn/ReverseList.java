package com.monster.learn;

public class ReverseList {

    // 100.00%
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next; 
        }
        return pre;
    } 

}
