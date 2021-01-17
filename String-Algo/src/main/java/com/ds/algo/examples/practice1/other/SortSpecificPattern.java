package com.ds.algo.examples.practice1.other;

public class SortSpecificPattern {

    private static final int[] inputData = {5, 4, 3, 2, 1};
//    private static final int[] inputData = {5, 4, 6, 3, 1, 7, 2};
//    private static final int[] inputData = {1, 4, 3, 2, 5};
//    private static final int[] inputData = {1, 5, 4, 3, 2};
//    private static final int[] inputData = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int[] ints = sortData(inputData);

        for (int i = 0; i < ints.length; i++) {
            System.out.print("| " + ints[i]);
        }
        System.out.println();
        System.out.println("Sorting Done!");
    }

    private static int[] sortData(int[] inputData) {
        if (inputData.length == 1) {
            return inputData;
        }

        int temp = 0;
        for (int i = 0; i < inputData.length; i++) {

            if(i == inputData[i] - 1){
                continue;
            }

            int tempIndex = inputData[i] - 1;//4,3,1

            if(Math.abs(inputData[tempIndex] - 1) == i){
                int value = inputData[i];
                inputData[i] = inputData[tempIndex];
                inputData[tempIndex] = value;
                continue;
            }

            if(temp != 0) {
                int value = inputData[temp - 1];
                inputData[temp -1] = temp;
                temp = value;
                continue;
            }

            while (Math.abs(inputData[tempIndex] - 1) != i) {
                tempIndex = inputData[tempIndex] - 1;
            }

            temp = inputData[inputData[i] - 1];
            inputData[inputData[i] - 1] = inputData[i];
            inputData[i] = inputData[tempIndex];

        }
        return inputData;
    }
}
