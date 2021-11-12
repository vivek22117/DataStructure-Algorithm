package com.ds.algo.examples.algoacademy;


/*
Input: nums = [-2, -5, 6, -2, -3, 1, 5, -6]
Output: 7
Explanation: sum([6, -2, -3, 1, 5]) = 7
 */
public class MaxSumSubArray {

    private static int[] input = {-2, -5, 6, 2, -3, 1, 6, -6};

    public static void main(String[] args) {
        MaxSumSubArray max = new MaxSumSubArray();
        int result = max.maxSum(input);
        System.out.println(result);

        int result1 = max.maxSumSubArray(input);
        System.out.println(result1);
    }


    public int maxSum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for(int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                sum = Math.max(sum, tempSum);
            }
        }

        return sum;
    }

    public int maxSumSubArray(int[] nums) {
        int result = nums[0];
        int maxSum = 0;
        for(int val : nums) {
            maxSum = val + Math.max(maxSum, 0);
            result = Math.max(result, maxSum);
        }

        return result;
    }
}
