package com.monster.learn;

import java.util.LinkedList;

public class IsSymmetric {
	//100.00%
	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}

	private boolean check(TreeNode left, TreeNode right) {
		if (null == left && null == right) {
			return true;
		}
		if (null == left || null == right) {
			return false;
		}
		return left.val == right.val && check(left.left, right.right) && check(left.right, right.left); 
	}
}
