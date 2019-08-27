package com.monster.learn;

//96.44%
public class Rob3 {
    // max = max(max, max + next2);
    public int rob(TreeNode root) {
        return dfs(root)[1];
    }
    private int[] dfs(TreeNode root) {
        int[] res = new int[]{0,0};
        if (root != null) {
            int[] robLeft = dfs(root.left);
            int[] robRight = dfs(root.right);
            res[0] = robLeft[1] + robRight[1];
            res[1] = Math.max(robLeft[0] + robRight[0] + root.val, res[0]);
        }
        return res;
    }

    
}