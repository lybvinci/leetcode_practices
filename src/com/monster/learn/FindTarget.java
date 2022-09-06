package com.monster.learn;

import java.util.HashSet;

public class FindTarget {
	HashSet<Integer> set = new HashSet<>();
	//94.42%
	public boolean findTarget(TreeNode root, int k) {
		if (null == root) {
			return false;
		}
		if (set.contains(k - root.val)) {
			return true;
		}
		set.add(root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}
