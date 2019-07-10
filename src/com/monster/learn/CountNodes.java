package com.monster.learn;

//89.61%
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 1;
        if (root.left != null) {
            sum += countNodes(root.left);
        }  
        if (root.right != null) {
            sum += countNodes(root.right);
        }
        return sum;
    }
}