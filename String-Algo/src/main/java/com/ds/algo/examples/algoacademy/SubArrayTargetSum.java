package com.ds.algo.examples.algoacademy;


/*
Input: [10, 3, 5, 8, 6, 12, 20, 15, 31],   Target:31
Output: [5,8,6,12]
Explanation: Subarray with sum equal to Target
 */
public class SubArrayTargetSum {

    private static int[] input = {10, 3, 5, 8, 6, 12, 20, 15, 31};

    public static void main(String[] args) {
        SubArrayTargetSum sum = new SubArrayTargetSum();
        String result = sum.getSubArray(input, 31);
        System.out.println(result);
    }

    public String getSubArray(int[] nums, int target) {
        String result = "";
        int N = nums.length;

        if(N == 0) {
            return "";
        }

        int startIndex = 0;
        int sum = nums[0];
        int endIndex = 1;

        while (endIndex < N) {

            if(sum < target) {
                sum += nums[endIndex];
                endIndex++;
            } else if(sum > target && startIndex < endIndex) {
                sum -= nums[startIndex];
                startIndex++;
            } else {
                result = startIndex + " " + (endIndex - 1);
                break;
            }
        }
        return result;
    }
}
