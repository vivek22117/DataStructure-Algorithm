package com.ds.algo.examples.practice2.tree;

public class FirstMissingPositiveNum {

    private static int[] data = {7, -1, 5, 3, 5, 9 ,24, -9};

    public int firstMissingNum(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 1;
        }

        int N = nums.length;
        boolean containsOne = false;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                containsOne = true;
            }
            if(nums[i] <= 0 || nums[i] > N) {
                nums[i] = 1;
            }
        }

        if(containsOne) return 1;

        for(int i = 0; i < N; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

    }
}
