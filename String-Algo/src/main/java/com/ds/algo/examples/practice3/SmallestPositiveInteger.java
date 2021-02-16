package com.ds.algo.examples.practice3;

import java.util.Arrays;

public class SmallestPositiveInteger {

//    private static int[] data = {1,3,6,4,1,2};
//  private static int[] data = {1,2,3};
    private static int[] data = {-1, -2, -3};

    public static void main(String[] args) {
        findSmallestPositiveInt(data);
    }

    private static int findSmallestPositiveInt(int[] data) {
        Arrays.sort(data);

        if(data[data.length - 1] < 0) {
            return 1;
        }

        int smallestNum = Integer.MAX_VALUE;
        int index = 0;
        while (index < data.length) {
            if(data[index + 1] - data[index] > 1) {
                smallestNum = Math.min(smallestNum, data[index] + 1);
            }
            index++;
        }
        return smallestNum == Integer.MAX_VALUE ? data[data.length - 1] + 1 : smallestNum;
    }
}
