package com.monster.learn;

import java.util.Stack;

public class GetIntersectionNode160 {
    // 15.57%
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stackA = addToStack(headA);
        Stack<ListNode> stackB = addToStack(headB);
        if (stackA.peek() != stackB.peek()) {
            return null;
        }
        ListNode pre = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode la = stackA.pop();
            ListNode lb = stackB.pop();
            if (la != lb) {
                return pre;
            } else {
                pre = la;
            }
        }
        return pre;
    }

    private Stack<ListNode> addToStack(ListNode head) {
        Stack<ListNode> stackA = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stackA.push(tmp);
            tmp = tmp.next;
        }
        return stackA;
    }
}