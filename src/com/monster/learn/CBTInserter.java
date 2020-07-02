package com.monster.learn;

import java.util.LinkedList;
import java.util.Queue;

//24.87%
public class CBTInserter {
  TreeNode root;
  Queue<TreeNode> queue;
  public CBTInserter(TreeNode root) {
    this.root = root;
    queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      TreeNode node = queue.peek();
      if (node.left == null || node.right == null) {
        break;
      } else {
        queue.add(node.left);
        queue.add(node.right);
        queue.poll();
      }
    }
  }

  public int insert(int v) {
    TreeNode node = new TreeNode(v);
    TreeNode peek = queue.peek();
    if (peek.left == null) {
      peek.left = node;
    } else {
      peek.right = node;
      queue.add(peek.left);
      queue.add(peek.right);
      queue.poll();
    }
    return peek.val;
  }
  
  public TreeNode get_root() {
    return root;
  }  
}