package com.ds.algo.examples;

public class FindThreeLargestNumbers {

    private static int[] inputData = {5, 4, 43, -2, -14, 67, 18, 0, 83, 9, -5, 36};

    public static void main(String[] args) {
        findThreeLargest(inputData);
    }

    private static void findThreeLargest(int[] inputData) {
        if(inputData.length < 3){
            throw new RuntimeException("Please provide valid input!");
        }

        int[] largestNum = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int value : inputData) {
            updateThreeLargestNum(largestNum, value);
        }
    }

    private static void updateThreeLargestNum(int[] largestNum, int value) {
        if(value > largestNum[2]){
            shiftNums(largestNum, value, 2);
        } else if(value > largestNum[1]) {
            shiftNums(largestNum, value, 1);
        }
    }

    private static void shiftNums(int[] largestNum, int value, int index) {
        for(int i = 0; i <= index; i++) {
            if(i == index) {
                largestNum[i] = value;
            } else {
                largestNum[i] = largestNum[i + 1];
            }
        }
    }
}
