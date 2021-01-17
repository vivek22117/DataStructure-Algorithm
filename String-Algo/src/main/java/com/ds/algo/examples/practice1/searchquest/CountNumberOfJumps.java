package com.ds.algo.examples.practice1.searchquest;

public class CountNumberOfJumps {
    private static final int[] inputData = {2, 2, -1, 3, 2, 3, 1, 4};

    public static void main(String[] args) {
        System.out.println(countNumberOfJumps(inputData));
    }

    private static int countNumberOfJumps(int[] inputData) {
        if(inputData.length == 1 || inputData.length == 0) {
            return 0;
        }

        int N = inputData.length;
        int i = 0;
        int count = 0;

        while (i < N) {
            int j = inputData[i];
            i = j + i;
            if(i < 0 || i> N-1) break;
            count++;
        }
        return count;
    }
}
