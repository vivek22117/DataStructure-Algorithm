package com.ds.algo.examples.algoacademy;


/*
Input: [10, 3, 5, 8, 6, 12, 20, 15, 31],   Target:31
Output: [5,8,6,12]
Explanation: Subarray with sum equal to Target
 */
public class SubArrayTargetSum {

    private static int[] input = {10, 3, 5, 8, 6, 12, 20, 15, 31};

    public static void main(String[] args) {

    }

    public String getSubArray(int[] nums, int target) {
        int N = nums.length;

        if(N == 0) {
            return "";
        }

        int startIndex = 0;
        int sum = nums[0];
        int endIndex = 1;

        while (endIndex < N) {
            if(sum == target) {
                return startIndex + " " + (endIndex - 1);
            }

            if(sum < target && endIndex < N) {
                sum += nums[endIndex];
                endIndex++;
            }
        }
    }
}
