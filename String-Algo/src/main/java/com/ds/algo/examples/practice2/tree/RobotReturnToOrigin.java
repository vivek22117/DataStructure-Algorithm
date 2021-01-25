package com.ds.algo.examples.practice2.tree;

public class RobotReturnToOrigin {

    public boolean isBackToOrigin(String path) {

        int pathUPAndDown = 0;
        int pathLeftAndRight = 0;

        for(int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);
            if(move == 'U') {
                pathUPAndDown++;
            } else if(move == 'D') {
                pathUPAndDown--;
            } else if(move == 'L') {
                pathLeftAndRight++;
            } else if(move == 'R') {
                pathLeftAndRight--;
            }
        }

        return pathUPAndDown == 0 && pathLeftAndRight == 0;

    }
}
