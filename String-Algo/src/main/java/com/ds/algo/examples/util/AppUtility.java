package com.ds.algo.examples.util;

public class AppUtility {

    public static int getRandomNum(Integer max, Integer min, Integer seed) {
        int count = (max - min) / seed;

        int random = (int) (((long) (count * Math.random()) * seed) + min);

        return random;
    }
}
