package com.ds.algo.examples.practice2.tree;

public class MissingNumberInSequence {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        int n = nums.length + 1;

        return (n * (n -1) / 2) - sum;
    }
}
