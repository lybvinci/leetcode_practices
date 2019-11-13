package com.monster.learn;

//49.53%
public class PathSum {
  public int pathSum(TreeNode root, int sum) {
    if (null == root) {
      return 0;
    }
    return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }
  private int dfs(TreeNode root, int sum) {
    if (null == root) {
      return 0;
    }
    if (root.val == sum) {
      return 1 + dfs(root.left, 0) + dfs(root.right, 0);
    }
    return dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
  }
}