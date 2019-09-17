package com.monster.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

//68.08%
public class RandomList382 {
    private LinkedList<Integer> list;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        list = new LinkedList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rd = new Random();
        return list.get(rd.nextInt(list.size()));
    }
}