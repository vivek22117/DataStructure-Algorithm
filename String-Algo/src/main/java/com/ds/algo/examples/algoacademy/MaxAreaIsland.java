package com.ds.algo.examples.algoacademy;


/*
Input:
1 1 0 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 1

Output: 6
Explanation:  There are 3 island with size 6, 2, 1
 */
public class MaxAreaIsland {

    private static int[][] input = {
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1}
    };

    public static void main(String[] args) {
        MaxAreaIsland size = new MaxAreaIsland();
        int result = size.findMaxArea(input);
        System.out.println(result);
    }

    public int findMaxArea(int[][] grid) {
        int maxResult = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int currentSize = dfs(grid, i, j);
                    System.out.println(currentSize);
                    maxResult = Math.max(maxResult, currentSize);
                }
            }
        }

        return maxResult;
    }

    private int dfs(int[][] grid, int row, int col) {
        if(row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || grid[row][col] == 0) {
         return 0;
        }

        grid[row][col] = 0;
        int size = 1;
        size += dfs(grid, row, col + 1);
        size += dfs(grid, row, col -1);
        size += dfs(grid, row - 1, col);
        size += dfs(grid, row + 1, col);

        return size;
    }

    private int findMaxAreaIsland(int[][] island) {
        if(island.length == 0) {
            return -1;
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < island.length; i++) {
            for(int j = 0; j < island[i].length; j++) {
                if(island[i][j] == 1) {
                    calculateArea(island, i, j);
                }
            }
        }
    }

    private int calculateArea(int[][] island, int row, int col) {

    }

}
