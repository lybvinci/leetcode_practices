package com.monster.learn;

//98.44%
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        ListNode o = head;
        ListNode e = head.next;
        ListNode p = e;

        while (null != o.next && null != e.next) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}