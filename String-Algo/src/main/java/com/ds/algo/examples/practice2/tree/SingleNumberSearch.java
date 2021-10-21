package com.ds.algo.examples.practice2.tree;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberSearch {
    
    private static int[] inputData = {2, 3, 4, 3, 2, 4, 1, 1, 5};

    public static void main(String[] args) {
        int singleNumber = findSingleNumber(inputData);
        System.out.println(singleNumber);
    }

    private static int findSingleNumber(int[] inputData) {
        if(inputData.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : inputData){
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for(Integer key : countMap.keySet()) {
            if(countMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
