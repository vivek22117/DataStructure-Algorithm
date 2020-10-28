package com.ds.algo.examples.linklist;

public class LinkListDS<T> {

    private Node<T> head = null;

    class Node<E>{
        private E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void addNode(T data) {
        if(isEmpty()) {
            head = new Node<>(data);
            return;
        }

        Node<T> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(data);
    }

    public void addNodeInBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void printLinkList() {
        Node<T> current = this.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("Printing Done...!!");
    }

}
