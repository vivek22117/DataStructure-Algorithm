package com.ds.algo.examples.practice3;

public class FindClosestValueInBST {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int n) {
            value = n;
        }
    }

    public int closestValue(TreeNode node, int k) {
        int currentClose = Integer.MAX_VALUE;

        findClosest(node, currentClose, k);
    }

    private void findClosest(TreeNode node, int currentClose, int k) {

    }
}
