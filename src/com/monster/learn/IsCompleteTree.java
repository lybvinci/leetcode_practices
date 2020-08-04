package com.monster.learn;

import java.util.LinkedList;
import java.util.Queue;

//95.33%
public class IsCompleteTree {
  public boolean isCompleteTree(TreeNode root) {
    boolean flag = true;
    // 左子树的标志位
    boolean isLeft = false;
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (queue.size() != 0) {
        TreeNode node = queue.poll();
        TreeNode left = node.left;
        TreeNode right = node.right;
        if ((left == null && right != null)// 左节点为null，且右节点不为null(是否为叶子节点)
            || (isLeft && (left != null || right != null))) {// 如果为左子树，则左右节点都不能为null
          flag = false;
          break;
        }
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        } else {
          isLeft = true;
        }
      }
    } else {
      flag = false;
    }
    return flag;
    
  }  
}