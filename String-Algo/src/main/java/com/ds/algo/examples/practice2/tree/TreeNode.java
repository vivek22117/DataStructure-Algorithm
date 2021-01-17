package com.ds.algo.examples.practice2.tree;

public class TreeNode<T> {

    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(TreeNode<T> node) {
        this.leftNode = node;
    }

    public void setRightNode(TreeNode<T> node) {
        this.rightNode = node;
    }
}
