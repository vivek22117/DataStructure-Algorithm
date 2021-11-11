package com.ds.algo.examples.algoacademy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Input: nums = [5, 9, 3, 6, 2, 1, 3, 2, 7, 5], k = 4

Output: [1, 2, 2, 3]
Explanation:Smallest number is 1, 2nd smallest is 2,
            3rd smallest is 2, 4th smallest is 3
 */
public class FindKthSmallest {

    private static int[] input = {5, 9, 3, 6, 2, 1, 3, 2, 7, 5};

    public static void main(String[] args) {

        FindKthSmallest smallest = new FindKthSmallest();
        int[] result = smallest.findKthSmallestNums(input, 5);
        System.out.println(Arrays.toString(result));

    }

//    Big O(n log k)
    public int[] findKthSmallestNums(int[] nums, int k) {
        if(nums.length == 0) {
            return new int[]{};
        }

        PriorityQueue<Integer> smallestKNums = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int val : nums) {
            if(smallestKNums.size() < k) {
                smallestKNums.add(val);
            } else if(val < smallestKNums.peek()) {
                smallestKNums.poll();
                smallestKNums.add(val);
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) {
            result[i] = smallestKNums.poll();
        }

        return result;
    }
}
