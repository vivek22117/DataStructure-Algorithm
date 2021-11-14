package com.ds.algo.examples.practice3;

public class FindClosestValueInBST {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int n) {
            value = n;
        }
    }

    public int closestValue(TreeNode node, int k) {
        int currentClose = Integer.MAX_VALUE;

        return findClosest(node, currentClose, k);
    }

    private int findClosest(TreeNode node, int currentClose, int k) {
        if(node == null) {
            return currentClose;
        }

        if(Math.abs(k - currentClose) > Math.abs(k - node.value)) {
            currentClose = node.value;
        }

        if(k > node.value) {
            return findClosest(node.right, currentClose, k);
        } else if(k < node.value) {
            return findClosest(node.left, currentClose, k);
        } else {
            return currentClose;
        }
    }
}
