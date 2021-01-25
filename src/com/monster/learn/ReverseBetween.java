package com.monster.learn;

//100.00%
public class ReverseBetween {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == 1) {
      return reverseN(head, n);
    }
    head.next = reverseBetween(head.next, m -1 , n -1);
    return head;
  } 

  private ListNode success = null;
  private ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
      success = head.next;
      return head;
    }
    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = success;
    return last;
  }
}
