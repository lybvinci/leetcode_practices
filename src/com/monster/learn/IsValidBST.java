package com.monster.learn;

import java.util.LinkedList;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		traverse(root);
		if (list.isEmpty()) {
			return true;
		}
		int pre = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= pre) {
				return false;
			}
		}
		return true;
	}

	LinkedList<Integer> list = new LinkedList<>();

	private void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		list.add(root.val);
		traverse(root.right);
	}
}
