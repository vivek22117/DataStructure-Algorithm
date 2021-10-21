package com.ds.algo.examples.algoacademy;

public class NumOfPathsToReachLastCell {

    private static int[][] input = {{4, 7, 1, 6}, {5, 7, 3, 9}, {3, 2, 1, 2}, {7, 1, 6, 3}};

    public static void main(String[] args) {
        NumOfPathsToReachLastCell paths = new NumOfPathsToReachLastCell();
        int result = paths.numOfPaths(input, 25);
        System.out.println(result);
    }

    public int numOfPaths(int[][] grid, int target) {
        if(target < 0) {
            return -1;
        }

        return findPaths(grid, 0, 0, target);
    }

    private int findPaths(int[][] grid, int row, int col, int target) {
        if(row == grid.length -1 && col == grid[0].length -1) {
            return (grid[row][col] - target == 0) ? 1 : 0;
        }

        if(row == grid.length -1) {
            return findPaths(grid, grid.length -1, col + 1, target);
        }

        if(col == grid[0].length - 1) {
            return findPaths(grid, row - 1, grid[row].length -1, target);
        }

        int rowPath = findPaths(grid, row + 1, col, target);
        int colPath = findPaths(grid, row, col + 1, target);

        return rowPath + colPath;

    }

}
