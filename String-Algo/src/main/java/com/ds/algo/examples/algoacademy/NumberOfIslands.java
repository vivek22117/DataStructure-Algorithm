package com.ds.algo.examples.algoacademy;

import java.util.ArrayList;
import java.util.List;


/*
Input:
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 1

Output: [9, 1]
Explanation:  There are two island with size 9, 1
 */

public class NumberOfIslands {

    private static int[][] input = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
    };

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        List<Integer> result = islands.sizeOfIslands(input);
        System.out.println(result);
    }

    public List<Integer> sizeOfIslands(int[][] grid) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    result.add(dfs(grid, i, j));
                }
            }
        }

        System.out.println("Number of Islands: " + result.size());
        return result;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int counter = 1;
        counter += dfs(grid, row + 1, col);
        counter += dfs(grid, row - 1, col);
        counter += dfs(grid, row, col + 1);
        counter += dfs(grid, row, col - 1);

        return counter;
    }
}
