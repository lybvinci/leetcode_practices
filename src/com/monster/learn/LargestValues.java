package com.monster.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {

	//89.47%
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (null == root) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				max = Math.max(max, cur.val);
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			res.add(max);
		}
		return res;
	}	
}
