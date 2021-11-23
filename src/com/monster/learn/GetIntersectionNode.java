package com.monster.learn;

import java.util.Stack;

//24.52%
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       Stack<ListNode> stackA = push(headA); 
       Stack<ListNode> stackB = push(headB); 
       ListNode pre = null;
       while (!stackA.empty() && !stackB.empty()) {
           ListNode a = stackA.pop();
           ListNode b = stackB.pop();
           if (a != b) {
               return pre;
           } else {
               pre = a;
           }
       }
        return pre;
    }

    private Stack<ListNode> push(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        return stack;
    }

}