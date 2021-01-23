package com.ds.algo.examples.practice2.tree;

import java.util.Random;
import java.util.stream.IntStream;

public class NumberOfIslands {
    private static int N = 5;
    public static int[][] inputMatrix = new int[N][N];

    public NumberOfIslands() {
        IntStream.iterate(0, e -> e + 1).limit(22).forEach(e -> {
            int i = new Random().nextInt(((N - 1) - 0) + 1);
            int j = new Random().nextInt(((N - 1) - 0) + 1);
            inputMatrix[i][j] = 1;
        });
    }

    public static void main(String[] args) {
        NumberOfIslands nums = new NumberOfIslands();
        printMatrix(inputMatrix);

        checkNumberOfIslands(inputMatrix);
    }

    private static int checkNumberOfIslands(int[][] inputMatrix) {
        if(inputMatrix == null || inputMatrix.length == 0) {
            return 0;
        }

        for(int i = 0; i < inputMatrix.length; i++) {
            for(int j =0; j < inputMatrix[i].length; j++) {

            }
        }
        return 0;
    }

    private static void printMatrix(int[][] inputMatrix) {
        for(int i = 0; i < inputMatrix.length; i++){
            System.out.print("|");
            for(int j = 0; j < inputMatrix[i].length; j++) {
                System.out.print(inputMatrix[i][j] + "|");
            }
            System.out.println();
        }
    }

}
