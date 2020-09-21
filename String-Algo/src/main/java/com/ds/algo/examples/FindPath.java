package com.ds.algo.examples;

import java.util.*;
import java.util.stream.IntStream;

public class FindPath {
    private static final Map<Integer, List<Integer>> inputData = new HashMap<>();
    private static final int [] paths = {1, 2, 3, 4};

    public static void main(String[] args) {
        populateMap(inputData);
        boolean pathAvailable = isPathAvailable(paths, inputData);
        System.out.println("Is Path Correct: " + pathAvailable);
    }

    private static boolean isPathAvailable(int[] paths, Map<Integer, List<Integer>> inputData) {
        boolean isPath = true;
        if(paths.length == 2) {
            List<Integer> integers = inputData.get(paths[0]);
            if(!integers.contains(paths[1])) {
                return false;
            } else {
                return true;
            }
        }

        for(int i = 0; i < paths.length; i++) {
            List<Integer> integers = inputData.get(paths[i]);
            if(i + 1 == paths.length) {
                break;
            }
            if(!integers.contains(paths[i + 1])) {
                isPath = false;
                break;
            }
        }
        return isPath;
    }

    private static void populateMap(Map<Integer, List<Integer>> inputData) {
        inputData.put(1, Arrays.asList(2, 3, 5, 6));
        inputData.put(2, Arrays.asList(3));
        inputData.put(3, Arrays.asList(4));
        inputData.put(4, Arrays.asList(20));
        inputData.put(5, Arrays.asList(22));
        inputData.put(6, new ArrayList<>());
        inputData.put(20, new ArrayList<>());
        inputData.put(22, new ArrayList<>());

    }
}

