package com.ds.algo.examples.algoacademy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Input: [2, 3, 1, 1, 4, 3, -2, 1]
Output: [2, 3, 1, 4, -2]
 */
public class RemoveDuplicates {

    private static int[] input = {2, 3, 1, 1, 4, 3, -2, 1};

    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int[] result = duplicates.process(input);
        System.out.println(Arrays.toString(result));

        int[] result2 = duplicates.processMoreEfficient(input);
        System.out.println(Arrays.toString(result2));

        int[] result3 = duplicates.processMostEfficiently(input);
        System.out.println(Arrays.toString(result3));
    }

//  Big O(n2)
    public int[] process(int[] nums) {
        if(nums.length == 0) {
            return new int[]{};
        }

        if(nums.length == 1) {
            return nums;
        }

        List<Integer> result = new ArrayList<>();
        for(int value : nums) {
            if(!result.contains(value)) {
                result.add(value);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

//  Big O(nlog n)
    public int[] processMoreEfficient(int[] nums) {
        if(nums.length == 0) {
            return new int[]{};
        }

        if(nums.length == 1) {
            return nums;
        }

        Arrays.sort(nums);

        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                System.out.println(index);
                nums[++index] = nums[i];
                System.out.println(index);
            }
        }
        return Arrays.copyOfRange(nums, 0, index + 1);
    }

//  Big O(n) & Space Big O (n)
    public int[] processMostEfficiently(int[] nums) {
        if(nums.length == 0) {
            return new int[]{};
        }

        if(nums.length == 1) {
            return nums;
        }

        HashSet<Integer> uniqueValues = new HashSet<>();
        for(int value : nums) {
            uniqueValues.add(value);
        }

        return uniqueValues.stream().mapToInt(i -> i).toArray();
    }
}
