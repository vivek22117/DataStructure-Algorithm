package com.ds.algo.examples.practice1.tree;

public class BSTImpl {

    public static class Employee {
        private Integer id;
        private String name;

        public Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public Node<Employee> insertNode(Node<Employee> head, Node<Employee> newNode) {
        if(head == null) {
            return newNode;
        }

        if(newNode.getElement().id <= head.getElement().id) {
            head.setLeftNode(insertNode(head.getLeftNode(), newNode));
        } else {
            head.setRightNode(insertNode(head.getRightNode(), newNode));
        }
        return head;
    }

    public Node<Employee> lookUp(Node<Employee> head, Node<Employee> newNode) {
        if(head == null) {
            return null;
        }

        if(head.getElement().id == newNode.getElement().id) {
            return head;
        }

        if(head.getElement().id  > newNode.getElement().id) {
           return lookUp(head.getLeftNode(), newNode);
        } else {
            return lookUp(head.getRightNode(), newNode);
        }
    }

    public void preOrderDPSTraversal(Node<Employee> head) {
        if(head == null) {
            return;
        }

        process(head);
        preOrderDPSTraversal(head.getLeftNode());
        preOrderDPSTraversal(head.getRightNode());
    }

    public void postOrderDPSTraversal(Node<Employee> head) {
        if (head == null) {
            return;
        }

        postOrderDPSTraversal(head.getLeftNode());
        postOrderDPSTraversal(head.getRightNode());
        process(head);
    }

    private void process(Node<Employee> head) {
        System.out.print("| " + head.getElement().id);
    }

}
