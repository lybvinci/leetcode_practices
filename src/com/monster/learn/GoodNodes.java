package com.monster.learn;

import java.util.List;

//100.00%
public class GoodNodes {

	private int mCount;

	public int goodNodes(TreeNode root) {
		mCount = 0;
		helper(root, Integer.MIN_VALUE);
		return mCount;
	}	

	private void helper(TreeNode node, int curMax) {
		if (node == null) {
			return;
		}
		if (node.val >= curMax) {
			mCount++;
		}
		curMax = Math.max(curMax, node.val);
		if (node.left != null) {
			helper(node.left, curMax);
		}
		if (node.right != null) {
			helper(node.right, curMax);
		}
	}
}
