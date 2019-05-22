package com.monster.learn;

public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        obj.insertionSortList(node);
    }

    // 91.86%
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0), p = head;
        dummyHead.next = head;
        while(p.next != null) {
            if(p.val <= p.next.val) {  //p 的值不小于下一节点
                p = p.next;
            } else {
                ListNode temp = p.next, q = dummyHead;
                p.next = p.next.next;
                while(q.next.val < temp.val)  //找到第一个大于该节点的前一节点
                    q = q.next;
                temp.next = q.next;  //将 temp 节点插入
                q.next = temp;
            }
        }
        return dummyHead.next;
    }
}