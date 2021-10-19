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

        int result2 = sum.getMinSumMemoization(grid);
        System.out.println(result2);
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
}
