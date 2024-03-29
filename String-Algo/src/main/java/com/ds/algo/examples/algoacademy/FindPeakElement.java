package com.ds.algo.examples.algoacademy;


/*
Input: nums = [1, 2, 1, 3, 5, 6, 4]
Output: Index 1 or 5

Input: nums = [1, 2, 3, 1]
Output: Index 2
 */
public class FindPeakElement {

    private static int[] input = {1, 2, 5, 3, 5, 6, 4};

    public static void main(String[] args) {
        FindPeakElement peak = new FindPeakElement();
        int result = peak.getPeak(input);

        int peakElement = peak.getPeakElement(input);
        System.out.println(peakElement);

        System.out.println(result);

        int peakElementFromArray = getPeakElementFromArray(input);
        System.out.println(peakElementFromArray);

    }

    private static int getPeakElementFromArray(int[] nums) {
        if( nums.length == 0) {
            return -1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(currentElementIsPeak(nums, i)) {
                return i;
            }
        }
        return 0;
    }

    private static boolean currentElementIsPeak(int[] nums, int index) {
        if(index == 0) {
            return nums[index] > nums[index + 1];
        }

        if(index == nums.length -1) {
            return nums[index] > nums[index -1];
        }

        return nums[index -1] < nums[index] && nums[index] > nums[index + 1];
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

    private int getPeakElement(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(isPeakElement(nums, i)) {
                return i;
            }
        }

        return 0;
    }

    private boolean isPeakElement(int[] nums, int index) {
        if(index == 0) {
            return nums[index] > nums[index + 1];
        }

        if(index == nums.length - 1) {
            return nums[index] > nums[index - 1];
        }

        return nums[index - 1] < nums[index] && nums[index] > nums[index + 1];
    }
}
