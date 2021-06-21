package com.monster.learn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//79%
public class FindDuplicateSubtrees {
	private HashMap<String, Integer> duplicateStr = new HashMap<>();
	private LinkedList<TreeNode> res = new LinkedList<>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverse(root);
		return res;
	}
	
	private String traverse(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String left = traverse(root.left);
		String right = traverse(root.right);
		String tmp = left + "," + right + "," + root.val;
		int count = duplicateStr.getOrDefault(tmp, 0);
		if (count == 1) {
			res.add(root);
		}
		duplicateStr.put(tmp, count + 1);
		return tmp;
	}

}
