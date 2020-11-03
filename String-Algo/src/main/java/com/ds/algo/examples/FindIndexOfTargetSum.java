package com.ds.algo.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class FindIndexOfTargetSum {

    private static int[] inputData = {3,6,8,7,15,9,11,0};
    private static int target  = 12;

    public static void main(String[] args) {
        int N = inputData.length;
        int[][] copyOf2DArray = createCopyOf2DArray(inputData);
        Arrays.sort(copyOf2DArray, Comparator.comparingInt(new ToIntFunction<int[]>() {
            @Override
            public int applyAsInt(int[] value) {
                return value[0];
            }
        }));
    }

    private static int[][] createCopyOf2DArray(int[] inputData) {
        int[][] copy = new int[inputData.length][2];
        IntStream.range(0, inputData.length).forEach(e -> {
            copy[e][0] = inputData[e];
            copy[e][1] = e;
        });
        return copy;
    }
}
