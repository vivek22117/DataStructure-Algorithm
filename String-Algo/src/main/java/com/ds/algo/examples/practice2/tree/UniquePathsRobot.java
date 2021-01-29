package com.ds.algo.examples.practice2.tree;

public class UniquePathsRobot {


    public int findUniquePathsForRobot(int[][] data, int m, int n) {


        for(int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(i == 0 || j == 0) {
                    data[i][j] = 1;
                } else {
                    data[i][j] = data[i][j-1] + data[i -1][j];
                }
            }
        }

        return data[data.length - 1][n -1];
    }


}
