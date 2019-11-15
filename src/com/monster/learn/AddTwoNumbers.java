package com.monster.learn;

import java.util.LinkedList;

//72.67%
public class AddTwoNumbers {
  public static void main(String[] args) {
    AddTwoNumbers atn = new AddTwoNumbers();
    ListNode node = new ListNode(7);
    node.next = new ListNode(2);
    node.next.next = new ListNode(4);
    node.next.next.next = new ListNode(3);

    ListNode node2 = new ListNode(5);
    node2.next = new ListNode(6);
    node2.next.next = new ListNode(4);
    atn.addTwoNumbers(node, node2);
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    LinkedList<Integer> a1 = new LinkedList<>();
    LinkedList<Integer> a2 = new LinkedList<>();
    ListNode head = l1;
    while (head != null) {
      a1.add(head.val);
      head = head.next;
    }
    head = l2;
    while (head != null) {
      a2.add(head.val);
      head = head.next;
    }
    int index1 = a1.size() - 1;
    int index2 = a2.size() - 1;
    LinkedList<Integer> a3 = new LinkedList<>();
    int jinwei = 0;
    while (index1 >= 0 && index2 >= 0) {
      int x = a1.get(index1);
      int y = a2.get(index2);
      int sum = x + y + jinwei;
      a3.addFirst(sum % 10);
      jinwei = sum / 10;
      index1--;
      index2--;
    }
    while (index1 >= 0) {
      int x = a1.get(index1);
      int sum = x + jinwei;
      a3.addFirst(sum % 10);
      jinwei = sum / 10;
      index1--;
    }
    while (index2 >= 0) {
      int x = a2.get(index2);
      int sum = x + jinwei;
      a3.addFirst(sum % 10);
      jinwei = sum / 10;
      index2--;
    }
    if (jinwei > 0) {
      a3.addFirst(jinwei);
    }
    ListNode dummy = new ListNode(-1);
    ListNode ret = dummy;
    for (int i : a3) {
      ListNode node = new ListNode(i);
      dummy.next = node;
      dummy = dummy.next;
    }
    return ret.next;
  }
}