package com.ds.algo.examples.algoacademy;


/*
Input: nums = [1, 2, 1, 3, 5, 6, 4]
Output: 1 or 5

Input: nums = [1, 2, 3, 1]
Output: 2
 */
public class FindPeakElement {

    private static int[] input = {1, 2, 1, 3, 5, 6, 4};

    public static void main(String[] args) {
        FindPeakElement peak = new FindPeakElement();
        int result = peak.getPeak(input);

        System.out.println(result);
    }


    public int getPeak(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(isPeak(nums, i)) {
                return i;
            }
        }

        return 0;
    }

    private boolean isPeak(int[] nums, int i) {
        if(i == 0) {
            return nums[i] > nums[i + 1];
        }

        if(i == nums.length - 1) {
            return nums[i] > nums[i - 1];
        }

        return nums[i - 1] < nums[i] && nums[i] > nums[i + 1];
    }
}
