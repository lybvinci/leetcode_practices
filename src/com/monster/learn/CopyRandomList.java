package com.monster.learn;

import java.util.LinkedList;

public class CopyRandomList {
    public static void main(String[] args) {
        Node head = new Node(1, null, null);
        head.random = head;
        // Node next = new Node(2, null ,null);
        // head.next = next;
        // head.random = next;
        // next.random = next;
        CopyRandomList obj = new CopyRandomList();
        Node res = obj.copyRandomList(head);
        System.out.println(res);
    }

    // 5.64%
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        LinkedList<Node> originList = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<>();
        Node temp = head;
        while(temp != null) {
            originList.add(temp);
            list.add(new Node(temp.val, null, null));
            temp = temp.next;
       } 
       Node resultHead = list.get(0);
       temp = resultHead;
       for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                temp.next = list.get(i + 1);
            }
            int index = originList.indexOf(originList.get(i).random);
            if (index >= 0) {
                temp.random = list.get(index);
            }
            temp = temp.next;
       }

       return resultHead;
    }
}