package com.ds.algo.examples.practice3;

public class FindMinInArray {

    private static int[] input = {2,3, 6 ,5 ,4};

    public static void main(String[] args) {
        int min = findMin(input);
        System.out.println(min);

        int secondMin = findSecondMin(input);
        System.out.println(secondMin);
    }

//    O(n)
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

}
