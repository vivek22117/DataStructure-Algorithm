package com.ds.algo.examples.algoacademy;


/*
1: Water
2: Land

Input:
1 1 1 1 1 1
1 0 0 1 0 1
1 0 0 1 0 1
0 1 1 0 1 1

Output: 2
Explanation:  There are 3 island with size 6, 2, 1
 */
public class NumOfClosedIslands {

    private static int[][] grid = {
            {1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0, 1},
            {0, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) {
        NumOfClosedIslands isLands = new NumOfClosedIslands();
        int result = isLands.countClosedIslands(grid);
        System.out.println(result);
    }

    public int countClosedIslands(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int closedIslands = 0, rows = grid.length, cols = grid[0].length;

        // We should skip the perimeter cells as they needs to be water to form closed Islands
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    if(isClosedIsland(grid, i, j, rows, cols)) {
                        closedIslands++;
                    }
                }
            }
        }

        return closedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j, int rows, int cols) {
        // -1 means visited
        // 1 is water
        // 0 land

        if(grid[i][j] == -1 || grid[i][j] == 1) {
            return true;
        }

        // above condition means now we have 0 (land) in the cell
        // First we need to check whether this cell is on PERIMETER
        if(isOnPerimeter(grid, i, j, rows, cols)) {
            return false;
        }

        grid[i][j] = -1;
        // Now check for all the directions
        boolean left = isClosedIsland(grid, i, j - 1, rows, cols);
        boolean right = isClosedIsland(grid, i, j + 1, rows, cols);
        boolean up  = isClosedIsland(grid, i - 1, j, rows, cols);
        boolean down = isClosedIsland(grid, i + 1, j, rows, cols);

        return left && right && up && down;
    }

    private boolean isOnPerimeter(int[][] grid, int i, int j, int rows, int cols) {
        return i == 0 || j == 0 | i == rows - 1 || j == cols -1;
    }
}
