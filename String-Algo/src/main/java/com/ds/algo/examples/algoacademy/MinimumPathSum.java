package com.ds.algo.examples.algoacademy;


/*
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {

    private static int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};

    public static void main(String[] args) {
        MinimumPathSum sum = new MinimumPathSum();

//        int result = sum.getMinSum(grid);
//        System.out.println(result);
//
//        int result2 = sum.getMinSumMemoization(grid);
//        System.out.println(result2);
//
//        int result3 = sum.getMinPathSum(grid);
//        System.out.println(result3);

        int result4 = sum.findMinPathSum(grid);
        System.out.println(result4);
    }

//  Big O(n + m)!  &
    public int getMinSum(int[][] grid) {
        return findMinSum(grid, 0, 0);
    }

    private int findMinSum(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[i].length){
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(findMinSum(grid, i + 1, j), findMinSum(grid, i, j + 1));
    }

//  Big O(n2)
    public int getMinSumMemoization(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];

        return findMin(grid, cache, 0, 0);
    }

    private int findMin(int[][] grid, int[][] cache, int i, int j) {
        if(i >= grid.length || j >= grid[i].length) {
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }

        if(cache[i][j] > 0) {
            return cache[i][j];
        }

        cache[i][j] = grid[i][j] +
                Math.min(findMin(grid, cache, i + 1, j), findMin(grid, cache, i, j + 1));
        return cache[i][j];
    }

    public int getMinPathSum(int[][] grid) {
        if(grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int top = i - 1 < 0 ? Integer.MAX_VALUE : grid[i - 1][j];
                int left = j - 1 < 0 ? Integer.MAX_VALUE : grid[i][j - 1];

                if(top == Integer.MAX_VALUE && left == Integer.MAX_VALUE) {
                    grid[i][j] += 0;
                } else {
                    grid[i][j] += Math.min(top, left);
                }
            }
        }
        return grid[rows - 1][cols - 1];

    }

    public int findMinPathSum(int[][] grid) {
        if(grid.length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 1; i < rows; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for(int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j-1];
        }

        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                grid[r][c] += Math.min(grid[r][c - 1], grid[r - 1][c]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
