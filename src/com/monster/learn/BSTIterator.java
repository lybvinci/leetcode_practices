package com.monster.learn;

import java.util.LinkedList;
import java.util.Queue;

//77.47%
public class BSTIterator {
    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        sort(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void sort(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            sort(root.left);
        }
        queue.add(root.val);
        if (root.right != null) {
            sort(root.right);
        }
    }
}