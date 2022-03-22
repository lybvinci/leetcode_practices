package com.monster.learn;

public class PruneTree {

	//100.00%
	public TreeNode pruneTree(TreeNode root) {
		TreeNode cur = root;
		helper(root);
		if (cur.left == null && cur.right == null && cur.val == 0) {
      return null;
    } else {
      return cur;
    }
	}	

	private int helper(TreeNode root) {
		if (null == root) {
			return 1;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (left == 0) {
			root.left = null;
		}
		if (right == 0) {
			root.right = null;
		}
		return (left == 1 || right == 1 || root.val == 1) ? 1 : 0;
	}

}
