package com.ds.algo.examples.practice2.tree;

import java.util.HashMap;

public class VerticalSumOfBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    private TreeNode root;
    public VerticalSumOfBST() {
        root = null;
    }
    public VerticalSumOfBST(TreeNode N) {
        root = N;
    }

    public int verticalSum() {
        return bstVerticalSum(root);
    }

    private int bstVerticalSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        verticalSumUtil(root, 0, map);

        System.out.println(map.entrySet());
        return 0;
    }

    private void verticalSumUtil(TreeNode root, int nodeVal, HashMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }

        verticalSumUtil(root.left, nodeVal + 1, map);
        map.put(nodeVal, map.getOrDefault(nodeVal, 0) + root.val);

        verticalSumUtil(root.right, nodeVal - 1, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        VerticalSumOfBST t = new VerticalSumOfBST(root);

        t.verticalSum();
    }
}
