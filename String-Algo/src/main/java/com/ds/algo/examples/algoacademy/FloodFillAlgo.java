package com.ds.algo.examples.algoacademy;


/*
Input:
[
  [1,3,1,0,0,2,2]
  [1,5,1,1,1,0,0]
  [4,2,1,1,0,0,3]
  [0,0,1,0,3,0,1]
]

Change the value of all 1s to 5s
 */
public class FloodFillAlgo {

    private static int[][] grid = {
            {1,3,1,0,0,2,2},
            {1,5,1,1,1,0,0},
            {4,2,1,1,0,0,3},
            {0,0,1,0,3,0,1}
    };

    public static void main(String[] args) {

    }

    public int[][] fillGrid(int[][] grid, int color) {
        if(grid.length == 0) {
            return new int[][];
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == color) {

                }
            }
        }
    }
}
