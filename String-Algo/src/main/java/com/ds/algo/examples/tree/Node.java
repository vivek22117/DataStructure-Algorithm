package com.ds.algo.examples.tree;

public class Node<T> {
    private T element;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }
}
