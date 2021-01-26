package com.ds.algo.examples.algoexpert;

public class MaxSubsetSumNoAdj {
    private static int[] data = {23, 47, 8, 41, 11, 33, 55};

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
