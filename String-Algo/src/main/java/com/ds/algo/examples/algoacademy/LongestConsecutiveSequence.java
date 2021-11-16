package com.ds.algo.examples.algoacademy;


import java.util.Arrays;

/*
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: Longest consecutive sequence is [1, 2, 3, 4].
             Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    private static int[] input = {100, 4, 200, 1, 3, 2};

    public static void main(String[] args) {

    }

    public int subSequence(int[] nums) {
        int result = 1;
        Arrays.sort(nums);

        int i = 0;
        while(i < nums.length) {
            int curr = nums[i];

            int j = i + 1;
            while (j < nums.length && nums[j] <= curr + 1) {
                if(nums[j] == curr + 1){
                    curr++;
                }
                j++;
            }
            result = Math.max(result, curr - nums[i] + 1);
            i = j;

        }
        return result;

    }
}
