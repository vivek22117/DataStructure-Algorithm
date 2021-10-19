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

        int result = sum.getMinSum(grid);
        System.out.println(result);
    }

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
}
