package com.ds.algo.examples.practice2.tree;


public class BinaryTreeOperations {

    public void breadthFirstTraversal(TreeNode root) throws CircularQueue.QueueOverFlowException, CircularQueue.QueueUnderFlowException {
        if(root == null) {
            return;
        }

        CircularQueue<TreeNode> queue = new CircularQueue<>(TreeNode.class);
        queue.enqueue(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            processNode(node);

            if(node.getLeftNode() != null) {
                queue.enqueue(node.getLeftNode());
            }

            if(node.getRightNode() != null) {
                queue.enqueue(node.getRightNode());
            }
        }
    }

    public void preOrderDepthFirstTraversal(TreeNode root) {
        if(root == null) {

        }
    }

    private void processNode(TreeNode node) {
        System.out.println("node = [" + node.getData() + "]");

    }
}
