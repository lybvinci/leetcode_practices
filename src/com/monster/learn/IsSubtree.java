package com.monster.learn;

public class IsSubtree {

	//5.18%
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		String rootStr = walk(root);
		String subRootStr = walk(subRoot);
		return rootStr.contains(subRootStr);
	}	

	private String walk(TreeNode root) {
		if (null == root) {
			return "$";
		}
		String str = walk(root.left) + "#";
		str += walk(root.right) + "#";
		return str + root.val + "#";
	}

}
