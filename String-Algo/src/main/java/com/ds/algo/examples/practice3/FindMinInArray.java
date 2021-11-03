package com.ds.algo.examples.practice3;

public class FindMinInArray {

    private static int[] input = {2,3, 6 ,5 ,4, 8, 5, 0};

    public static void main(String[] args) {
        int min = findMin(input);
        System.out.println(min);

        int secondMin = findSecondMin(input);
        System.out.println(secondMin);

        int kthMin = findKthMin(input, 3);
        System.out.println(kthMin);
    }

//    O(n) 2,3, 6 ,5 ,4, 8, 5, 0
    private static int findMin(int[] input) {
        if(input.length < 2) {
            return input[0];
        }

        int min = input[0];
        for (int i : input) {
            if(i < min) {
                min = i;
            }
        }

        return min;
    }

//    O(n) 2,3, 6 ,5 ,4, 8, 5, 0
    private static int findSecondMin(int[] input) {
        if(input.length < 2) {
            return input[0];
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i : input) {
            if(i < min1) {
                min2 = min1;
                min1 = i;
            } else if(i < min2) {
                min2 = i;
            }
        }

        return min2;
    }

    private static int findKthMin(int[] input, int k) {
        if(input.length < 2) {
            return input[0];
        }

        int min = Integer.MAX_VALUE;
        for(int i : input) {
            if(i < min) {
                min = i;
            }
        }

        int secondMin = Integer.MAX_VALUE;
        for(int i : input) {
            if(i < secondMin && i > min || secondMin == min) {
                secondMin = i;
            }
        }

        int thirdMin = Integer.MAX_VALUE;
        for(int i : input) {
            if(i < thirdMin && i > secondMin || thirdMin == secondMin) {
                thirdMin = i;
            }
        }

        return thirdMin;
    }

}
