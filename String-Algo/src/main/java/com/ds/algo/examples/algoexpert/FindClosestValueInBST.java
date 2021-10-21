package com.ds.algo.examples.algoexpert;

public class FindClosestValueInBST {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            value = x;
        }
    }

    public int findClosestValue(TreeNode node, int k) {

        int currentClosest = Integer.MAX_VALUE;

        return findClosestValueHelper(node, k, currentClosest);
    }

    private int findClosestValueHelper(TreeNode node, int target, int currentClosest) {
        if(node == null) {
            return currentClosest;
        }

        if(Math.abs(target - currentClosest) > Math.abs(target - node.value)) {
            currentClosest = node.value;
        }

        if(target > node.value) {
            return findClosestValueHelper(node.right, target, currentClosest);
        } else if(target < node.value) {
            return findClosestValueHelper(node.left, target, currentClosest);
        } else {
            return currentClosest;
        }
    }

    public static void main(String[] args) {

    }
}
