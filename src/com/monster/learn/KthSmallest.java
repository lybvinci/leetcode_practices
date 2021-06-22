package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//6.96%
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        helper(root, nums, k);        
        if (nums.size() >= k) {
            return nums.get(k - 1);
        } else {
            return -1;
        }
        
    }

    private boolean helper(TreeNode root, List<Integer> nums, int k) {
        if (nums.size() >= k) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean ret = false;
        ret = helper(root.left, nums, k);
        if (ret) {
            return true;
        }
        nums.add(root.val);
        if (nums.size() >= k) {
            return true;
        }
        ret = helper(root.right, nums, k);
        if (ret) {
            return true;
        }
        return false;
    }

    //100%
    public int kthSmallest2(TreeNode root, int k) {
      traverse(root, k);
      return res;
    }

    private int rank = 0;
    private int res = 0;

    private void traverse(TreeNode root, int k) {
      if (root == null) {
        return;
      }
      traverse(root.left, k);
      rank++;
      if (rank == k) {
        res = root.val;
        return;
      }
      traverse(root.right, k);
    }

}