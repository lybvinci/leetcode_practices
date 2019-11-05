package com.monster.learn;

//100%
public class Flatten430 {
  // Definition for a Node.
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  };

  public Node flatten(Node head) {
    helper(head);
    return head;
  }

  private Node helper(Node head) {
    if (head == null) {
      return head;
    }
    if (null != head.child) {
        Node child = head.child;
        Node next = head.next;
        head.next = child;
        child.prev = head;
        head.child = null;
        Node childtail = helper(child);
        if (next != null){
            childtail.next = next;
            next.prev = childtail;
            return helper(next);
        }
         return childtail;
    } else {
      if (head.next == null) {
        return head;
      }
      return helper(head.next);
    }
  }
}