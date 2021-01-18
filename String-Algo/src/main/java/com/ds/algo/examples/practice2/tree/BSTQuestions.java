package com.ds.algo.examples.practice2.tree;

public class BSTQuestions {

    public class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    public TreeNode<Employee> insert(TreeNode<Employee> head, TreeNode<Employee> newNode) {
        if (head == null) {
            return newNode;
        }

        if (newNode.getData().id <= head.getData().id) {
            head.setLeftNode(insert(head.getLeftNode(), newNode));
        } else {
            head.setRightNode(insert(head.getRightNode(), newNode));
        }

        return head;
    }

    public TreeNode<Employee> lookUp(TreeNode<Employee> head, TreeNode<Employee> searchNode) {
        if (head == null) {
            return null;
        }

        if (head.getData().id == searchNode.getData().id) {
            return head;
        }

        if (searchNode.getData().id < head.getData().id) {
            return lookUp(head.getLeftNode(), searchNode);
        } else {
            return lookUp(head.getRightNode(), searchNode);
        }
    }

    public boolean isIdenticalBST(TreeNode<Employee> treeOne, TreeNode<Employee> treeTwo) {
        if (treeOne == null && treeTwo == null) {
            return true;
        }

        if (treeOne == null) {
            return false;
        } else if (treeTwo == null) {
            return false;
        }

        if(isIdenticalBST(treeOne.getLeftNode(), treeTwo.getLeftNode())
                && isIdenticalBST(treeOne.getRightNode(), treeTwo.getRightNode())) {
            return treeOne.getData().id == treeTwo.getData().id;
        }

        return false;
    }
}
