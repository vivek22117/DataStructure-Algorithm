package com.ds.algo.examples.practice1.searchquest;

public class FindMaxSumSubArray {

    private static final int[] inputData = {6, 5, 6 ,-3, 1, 8, -4, 9, 5};

    public static void main(String[] args) {

        int maxSumSubArray = findMaxSumSubArray(inputData);
        System.out.println("Maximum sum: " + maxSumSubArray);
    }

    private static int findMaxSumSubArray(int[] inputData) {
        if(inputData.length == 1) {
           return inputData[0];
        }

        int N = inputData.length;
        int i = 0;
        int sum = Integer.MIN_VALUE;

        for(int e = 0; e < N; e++) {
            if(inputData[e] > 0) {
                int r = e + 1;
                int interSum = inputData[e];
                while (r < N){
                    if(inputData[r] < 0) break;
                    interSum = interSum + inputData[r];
                    r++;
                }
                sum = Math.max(sum, interSum);
                e = r;
            }
        }
        return sum;
    }
}
