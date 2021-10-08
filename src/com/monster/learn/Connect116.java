package com.monster.learn;

import java.util.LinkedList;

public class Connect116 {
    //54.65% 
    public Node2 connect(Node2 root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node2> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node2 pre = queue.poll();
            if (null != pre.left) {
                queue.add(pre.left);
            }
            if (null != pre.right) {
                queue.add(pre.right);
            }
            for (int i = 1; i < size; i++) {
                pre.next = queue.poll();
                pre = pre.next;
                if (null != pre.left) {
                    queue.add(pre.left);
                }
                if (null != pre.right) {
                    queue.add(pre.right);
                }
            }
        }
        return root;
    }
}