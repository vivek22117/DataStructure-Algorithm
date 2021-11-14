package com.ds.algo.examples.algoacademy;


import java.util.stream.Stream;

/*
Input: nums = [1,2,3], [1,3,2]
Output: True
 */
public class FlipEquivalentBST {

    static class TreeNode<E> {
        TreeNode<E> left;
        TreeNode<E> right;

        E value;

        TreeNode(E value) {
            this.value = value;
        }

    }

    private static int[] bstInput1 = {1,2,3};
    private static int[] bstInput2 = {1,3,2};

    public static void main(String[] args) {
        Stream.iterate(0, i -> i + 1).forEach(value -> {
            TreeNode node1 = new TreeNode(bstInput1[value]);
        });

        TreeNode node1 = new TreeNode(bstInput1[i]);

    }


    public boolean isBSTFlipEquivalent(TreeNode<Integer> node1, TreeNode<Integer> node2) {

    }
}
