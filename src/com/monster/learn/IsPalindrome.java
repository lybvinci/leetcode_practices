package com.monster.learn;

//59.29%
public class IsPalindrome {
  ListNode left;
  public boolean isPalindrome(ListNode head) {
    left = head;
    return traverse(head); 
  }  
  private boolean traverse(ListNode right) {
    if (right == null) {
      return true;
    }
    boolean res = traverse(right.next);
    if (!res) {
      return false;
    }
    res = res && (left.val == right.val);
    left = left.next;
    return res;
  }

  //99.95%
  public boolean isPalindrome2(ListNode head) {
    ListNode left =head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      slow = slow.next;
    }
    ListNode right = reverse(slow);
    while (right != null) {
      if (left.val != right.val) {
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  } 

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
