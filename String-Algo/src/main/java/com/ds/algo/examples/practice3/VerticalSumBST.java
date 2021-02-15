package com.ds.algo.examples.practice3;

import java.util.HashMap;

public class VerticalSumBST {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            value = x;
        }

    }

    private TreeNode root;

    public VerticalSumBST(TreeNode N) {
        root = N;
    }

    public int verticalSum() {
        return bstVertical(root);
    }

    private int bstVertical(TreeNode root) {
        if(root == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        verticalSumHelper(root, 0, map);

        System.out.println(map.entrySet());

        return 0;
    }

    private void verticalSumHelper(TreeNode root, int nodeValue, HashMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }

        verticalSumHelper(root.left, nodeValue + 1, map);
        map.put(nodeValue, map.getOrDefault(nodeValue, 0) + 1);

        verticalSumHelper(root.right, nodeValue - 1, map);
    }
}
