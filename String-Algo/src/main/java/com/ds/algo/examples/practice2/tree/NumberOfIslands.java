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

        int islands = checkNumberOfIslands(inputMatrix);
        System.out.println("Total islands: " + islands);
    }

    private static int checkNumberOfIslands(int[][] inputMatrix) {
        if(inputMatrix == null || inputMatrix.length == 0) {
            return 0;
        }

        int rows = inputMatrix.length;
        int cols = inputMatrix[0].length;
        int numberOfIsland = 0;
        for(int i = 0; i < inputMatrix.length; i++) {
            for(int j =0; j < inputMatrix[i].length; j++) {
                if(inputMatrix[i][j] == 1) {
                    prepare_island(inputMatrix, i, j, rows, cols);
                    numberOfIsland += 1;
                }
            }
        }
        return numberOfIsland;
    }

    private static void prepare_island(int[][] inputMatrix, int i, int j, int rows, int cols) {

        if(i < 0 || i >= rows || j < 0 || j >= cols || inputMatrix[i][j] != 1) {
            return;
        }

        inputMatrix[i][j] = 2;

        prepare_island(inputMatrix, i, j +1, rows, cols);
        prepare_island(inputMatrix, i, j -1, rows, cols);
        prepare_island(inputMatrix, i + 1, j, rows, cols);
        prepare_island(inputMatrix, i -1, j, rows, cols);
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
