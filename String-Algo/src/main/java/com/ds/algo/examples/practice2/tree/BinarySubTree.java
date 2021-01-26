package com.ds.algo.examples.practice2.tree;

public class BinarySubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val= x;
        }
    }

    public boolean isSubTree(TreeNode treeA, TreeNode treeB){
        if(treeA == null) {
            return false;
        } else if(isSameTree(treeA, treeB)) {
            return true;
        } else {
            return isSubTree(treeA.left, treeB) || isSubTree(treeA.right, treeB);
        }
    }

    private boolean isSameTree(TreeNode treeA, TreeNode treeB) {
        if(treeA == null || treeB == null) {
            return treeA == null && treeB == null;
        } else if(treeA.val == treeB.val) {
            return isSameTree(treeA.left, treeB.left) && isSameTree(treeA.right, treeB.right);
        } else {
            return false;
        }

    }
}
