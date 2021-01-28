package com.monster.learn;

//100.00%
public class ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    ListNode a = head;
    ListNode b = a;
    for (int i = 0; i < k; i++) {
      if (b == null) {
        return head;
      }
      b = b.next;
    }
    ListNode newHead = reverse(a, b);
    a.next = reverseKGroup(b, k);
    return newHead;
  } 

  private ListNode reverse(ListNode head, ListNode b) {
    ListNode cur,pre,next;
    cur = next = head;
    pre = null;
    while (cur != b) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
