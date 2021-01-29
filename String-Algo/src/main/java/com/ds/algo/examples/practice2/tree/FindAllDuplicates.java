package com.ds.algo.examples.practice2.tree;

import java.util.Arrays;
import java.util.HashSet;

public class FindAllDuplicates {

    private static int[] inputData = {4,  6, 1, 8, 3, 4, 5, 7};

    public static int[] findDuplicates(int[] data) {
        HashSet<Integer> set  = new HashSet<>();
        int[] dup = new int[data.length/2];
        int index = 0;
        for(int i = 0; i < data.length;  i++) {

            if(set.contains(data[i])){
                dup[index++] = data[i];
            } else {
                set.add(data[i]);
            }
        }

        return dup;
    }


    public static void main(String[] args) {
        int[] duplicates = findDuplicates(inputData);
        System.out.println(Arrays.toString(duplicates));
    }

}
