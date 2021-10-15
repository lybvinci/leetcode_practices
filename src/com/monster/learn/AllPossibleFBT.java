package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
	//53.95%
	public List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> result = new ArrayList<>();
		if (n == 1) {
			result.add(new TreeNode(0));
			return result;
		} else if (n % 2 == 1) {
			for (int i = 1; i < n; i += 2) {
				List<TreeNode> left = allPossibleFBT(i);
				List<TreeNode> right = allPossibleFBT(n - 1 - i);
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode node = new TreeNode(0);
						node.left = l;
						node.right = r;
						result.add(node);
					}
				}
			}
		}
		return result;
	}	
}
