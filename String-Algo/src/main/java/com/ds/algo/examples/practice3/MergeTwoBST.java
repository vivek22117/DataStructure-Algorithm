package com.ds.algo.examples.practice3;

public class MergeTwoBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeBST(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }

        if(t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        t1.left = mergeBST(t1.left, t2.left);
        t1.right = mergeBST(t1.right, t2.right);

        return t1;
    }
}
