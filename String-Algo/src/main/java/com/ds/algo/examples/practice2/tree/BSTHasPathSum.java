package com.ds.algo.examples.practice2.tree;

public class BSTHasPathSum {

    public class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode(int x) {
            val = x;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        } else if(root.leftNode == null & root.rightNode == null && sum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.leftNode, sum - root.val) || hasPathSum(root.rightNode, sum - root.val);
        }
    }
}
