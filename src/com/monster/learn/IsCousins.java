package com.monster.learn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//36.62%
public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (null == root) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(root);
        while(!queue.isEmpty()) {
           int size = queue.size();
           boolean hasX = false;
           boolean hasY = false;
           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               if (node.val == x) {
                   hasX = true;
               }
               if (node.val == y) {
                   hasY = true;
               }
               if (node.left != null) {
                   queue.add(node.left);
               }
               if (node.right != null) {
                   queue.add(node.right);
               }
               if (node.left != null && node.right != null) {
                   map.put(node.left.val, node.right.val);
                   map.put(node.right.val, node.left.val);
               }

           } 
           if (hasX && hasY && map.getOrDefault(x, -1) != y) {
               return true;
           } else if (!hasX && !hasY) {
               continue;    
           } else {
               return false;
           }
        }

        return false;
    } 

    public static void main(String[] args) {
        IsCousins ic = new IsCousins();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.right = left2;
        right.right = right2;
        ic.isCousins(root, 4, 5);
    }

}
