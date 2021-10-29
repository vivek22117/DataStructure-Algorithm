package com.ds.algo.examples.algoacademy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroSumTriplet {

    private static int[] input = {0, -2, 7, 2,  4, -6};

    public static void main(String[] args) {
        ZeroSumTriplet triplet = new ZeroSumTriplet();
        List<List<Integer>> output = triplet.zeroSum(input);
        System.out.println(output.toString());
    }


    public List<List<Integer>> zeroSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tempSum = nums[i];
                if(nums[left] + nums[right] > tempSum) {
                    right--;
                } else if(nums[left] + nums[right] < tempSum) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

}
