package com.ds.algo.examples.practice2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MaximumWidthBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int n) {
            val = n;
        }

    }

    private TreeNode root;

    public int findMaxWidth(TreeNode root) throws CircularQueue.QueueUnderFlowException {
        if(root == null) {
            return  0;
        }

        int maxWidth = Integer.MIN_VALUE;

        CircularQueue<TreeNode> queue = new CircularQueue<>(TreeNode.class);
        while (!queue.isEmpty()) {
            System.out.println(queue.totalElements());

            List<TreeNode> listOfNode = new ArrayList<>();
            while (!queue.isEmpty()) {
                listOfNode.add(queue.dequeue());
            }

            maxWidth = Math.max(maxWidth, listOfNode.size());
            System.out.println(queue.totalElements());
            listOfNode.stream().iterator().forEachRemaining(new Consumer<TreeNode>() {
                @Override
                public void accept(TreeNode treeNode) {
                    try {
                        queue.enqueue(treeNode);
                    } catch (CircularQueue.QueueOverFlowException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println(queue.totalElements());
        }

        return maxWidth;
    }
}
