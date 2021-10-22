package com.ds.algo.examples.algoexpert;


/*
Input: nums = [47, 23, 8, 41, 11, 33, 55]

Non Adjacent Sum1 = 47 + 8 + 11 + 55  =>
Non Adjacent Sum2 = 23 + 41 + 33 =>
Non Adjacent Sum3 = 47 + 41 + 55 =>
Output: 143

 */
public class MaxSubsetSumNoAdj {
    private static int[] data = {47, 23, 8, 41, 11, 33, 55};

    public static int maxSubsetSumNoAdjacent(int[] data) {
        if(data.length == 0){
            return -1;
        } else if(data.length == 1) {
            return data[0];
        }

        int secondNum = data[0];
        int firstNum = Math.max(secondNum, data[1]);
        for(int i = 2; i < data.length; i++) {
            int currentNum = Math.max(firstNum, secondNum + data[i]);
            secondNum = firstNum;
            firstNum = currentNum;
        }
        return firstNum;
    }

    public static void main(String[] args) {
        int i = maxSubsetSumNoAdjacent(data);
        System.out.println(i);
    }
}
