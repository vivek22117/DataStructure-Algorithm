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
        FloodFillAlgo fill = new FloodFillAlgo();
        int[][] result = fill.fillGrid(grid, 1, 7);

        int[][] newGrid = fill.fillGridWithColor(grid, 0, 9);

    }

    public int[][] fillGrid(int[][] grid, int oldColor, int color) {
        printMatrix(grid);
        System.out.println();

        if(grid.length == 0) {
            return new int[][]{};
        }

        Math.min(oldColor, color);

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == oldColor) {
                    fill(grid, i, j, oldColor, color);
                }
            }
        }
        printMatrix(grid);
        return grid;
    }

    private void fill(int[][] grid, int row, int col, int oldColor, int color) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if(grid[row][col] != oldColor) {
            return;
        }

        grid[row][col] = color;
        fill(grid, row + 1, col, oldColor, color);
        fill(grid, row - 1, col, oldColor, color);
        fill(grid, row, col - 1, oldColor, color);
        fill(grid, row, col + 1, oldColor, color);
    }

    private static void printMatrix(int[][] inputMatrix) {
        for (int[] matrix : inputMatrix) {
            System.out.print("|");
            for (int i : matrix) {
                System.out.print(i + "|");
            }
            System.out.println();
        }
    }

    private int[][] fillGridWithColor(int[][] grid, int oldColor, int newColor) {
        if(grid.length == 0) {
            return new int[][]{};
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == oldColor) {
                    fillUpGrid(grid, i, j, oldColor, newColor);
                }
            }
        }

        printNewGrid(grid);
        return grid;

    }

    private void fillUpGrid(int[][] grid, int row, int col, int oldColor, int newColor) {
        if(row < 0 || row > grid.length || col < 0 || col > grid[0].length) {
            return;
        }

        if(grid[row][col] != oldColor) {
            return;
        }

        grid[row][col] = newColor;
        fillUpGrid(grid, row + 1, col, oldColor, newColor);
        fillUpGrid(grid, row -1, col, oldColor, newColor);
        fillUpGrid(grid, row, col + 1, oldColor, newColor);
        fillUpGrid(grid, row, col - 1, oldColor, newColor);
    }

    private void printNewGrid(int[][] grid) {
        for(int [] matrix : grid) {
            System.out.print("|");
            for(int i : matrix) {
                System.out.print(i + "|");
            }
            System.out.println();
        }
    }
}
