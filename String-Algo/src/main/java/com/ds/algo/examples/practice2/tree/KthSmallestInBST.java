package com.ds.algo.examples.practice2.tree;

public class KthSmallestInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode head, int k) {
        int[] nums = new int[2];

        inorder(head, nums, k);

        return nums[1];
    }

    private void inorder(TreeNode head, int[] nums, int k) {
        if(head == null) {
            return;
        }

        inorder(head.left, nums, k);
        if(++nums[0] == k) {
            nums[1] = head.val;
        }
        inorder(head.right, nums, k);
    }


    public static void main(String[] args) {
        Integer[] treeData = {5, 3, 6, 2, 4, null, null, 1};

        KthSmallestInBST smallest = new KthSmallestInBST();

    }


}
