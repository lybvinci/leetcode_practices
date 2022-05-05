package com.monster.learn;

public class IsBalanced {
	//100.00%
	private boolean ret;
	public boolean isBalanced(TreeNode root) {
		ret = true;
		helper(root);
		return ret;
	}	

	private int helper(TreeNode root) {
		if (root == null || !ret) {
			return 0;
		}
		int depLeft = helper(root.left);
		int depRight = helper(root.right);
		if (Math.abs(depLeft - depRight) > 1) {
			ret = false;
		}
		return Math.max(depLeft, depRight) + 1;
	}

}
