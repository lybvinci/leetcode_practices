package com.monster.learn;

//100.00%
public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (null == root) {
      return null;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }  
}
