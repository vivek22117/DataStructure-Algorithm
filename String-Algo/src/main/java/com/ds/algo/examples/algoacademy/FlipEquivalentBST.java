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


    }


    public boolean isBSTFlipEquivalent(TreeNode<Integer> node1, TreeNode<Integer> node2) {
        if(node1 == null && node2 == null) {
            return false;
        }

        if(node1 == null || node2 == null || node1.value != node2.value) {
            return false;
        }

        boolean isLeftCheckEquivalent = isBSTFlipEquivalent(node1.left, node2.left) &&
                isBSTFlipEquivalent(node1.right, node2.right);

        boolean isRightCheckEquivalent = isBSTFlipEquivalent(node1.left, node2.right) &&
                isBSTFlipEquivalent(node1.right, node2.left);

        return isLeftCheckEquivalent || isRightCheckEquivalent;
    }
}
