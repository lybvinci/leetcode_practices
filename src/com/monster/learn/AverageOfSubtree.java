package com.monster.learn;

//100.00%
public class AverageOfSubtree {
	private int mCount = 0;

	public int averageOfSubtree(TreeNode root) {
		sumSubtree(root);
		return mCount;
	}

	private int[] sumSubtree(TreeNode root) {
		if (null == root) {
			return new int[]{0, 0};
		}
		int[] ret = new int[]{0, 0};
		if (root.left != null) {
			int[] tmp = sumSubtree(root.left);
			ret[0] += tmp[0];
			ret[1] += tmp[1];
		}
		if (root.right != null) {
			int[] tmp = sumSubtree(root.right);
			ret[0] += tmp[0];
			ret[1] += tmp[1];
		}
		ret[0] += root.val;
		ret[1]++;
		if (ret[0] / ret[1] == root.val) {
			mCount++;
		}
		return ret;
	}

	public static void main(String[] args) {
	}
}
