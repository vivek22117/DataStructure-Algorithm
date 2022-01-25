package com.ds.algo.examples.algoacademy;


/*
/*
Input:
[
  [3,4,5]
  [3,2,6]
  [2,2,1]
]

Output: 4
Because [3,4,5,6]
 */

public class LengthOfLongestIncreasingPath {

    private static int[][]  grid = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
    };

    public static void main(String[] args) {

    }

    public int longestIncreasingPath(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int longestPath = Integer.MIN_VALUE;

        int[][] cache = new int[rows][cols];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                return findLongestPath(grid, i, j, rows, cols, cache);
            }
        }

        return -1;
    }

    private int findLongestPath(int[][] grid, int i, int j, int rows, int cols, int[][] cache) {
        if(cache[i][j] > 0) {
            return cache[i][j];
        }

        int max = 0;

        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
