package com.monster.learn;


//66.87%
public class SufficientSubset {
    int sum = 0;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (null == root) {
            return null;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum < limit) {
                sum -= root.val;
                return null;
            } else {
                sum -= root.val;
                return root;
            }
        } else {
            root.left = sufficientSubset(root.left, limit);
            root.right = sufficientSubset(root.right, limit);
            sum -= root.val;
            if (root.left == null && root.right == null) {
                return null;
            } else {
                return root;
            }
        }
    }
}
