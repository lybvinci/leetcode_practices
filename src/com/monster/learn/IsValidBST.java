package com.monster.learn;

import java.util.LinkedList;

public class IsValidBST {
	//20.81%
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
			pre = list.get(i);
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

	public static void main(String[] args) {
		IsValidBST ivb = new IsValidBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		TreeNode right = new TreeNode(4);
		root.right = right;
		right.left = new TreeNode(3);
		right.right = new TreeNode(6);
		ivb.isValidBST(root);
	}
}
