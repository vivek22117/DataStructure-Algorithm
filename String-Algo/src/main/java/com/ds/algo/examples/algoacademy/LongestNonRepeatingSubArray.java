package com.ds.algo.examples.algoacademy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Input: nums = [2, 5, 6, 2, 3, 1, 5, 6]
Output: 5
Explanation: [5, 6, 2, 3, 1] or [6, 2, 3, 1, 5] are both valid and of maximum length 5
 */
public class LongestNonRepeatingSubArray {

    private static int[] input = {2, 5, 6, 2, 3, 1, 5, 6};

    public static void main(String[] args) {
        LongestNonRepeatingSubArray subArray = new LongestNonRepeatingSubArray();
        int result = subArray.subArray(input);
        System.out.println(result);


        int result2 = subArray.subArrayEfficient(input);
        System.out.println(result2);
    }

//  Big O(n3)
    public int subArray(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int searchValue = nums[j];
                if(Arrays.stream(Arrays.copyOfRange(nums, i, j)).anyMatch(value -> value == searchValue)){
                    break;
                }
                result = Math.max(result, j - i + 1);
            }
        }

        return result;
    }

//  Big O(n2)
    public int subArrayEfficient(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> uniqueSet = new HashSet<>();
            for(int j = i; j < nums.length; j++) {
                if(uniqueSet.contains(nums[j])) {
                    break;
                }
                result = Math.max(result, j - i + 1);
                uniqueSet.add(nums[j]);
            }
        }

        return result;
    }
}
