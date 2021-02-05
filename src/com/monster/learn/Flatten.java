package com.monster.learn;

//100.00%
public class Flatten {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    root.right = left;
    TreeNode tmp = root;
    while (tmp.right != null) {
      tmp = tmp.right;
    }
    tmp.right = right;
  } 
}
