package com.ds.algo.examples.practice2.tree;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i : numbers) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        for(int i : set) {
            return i;
        }

        return -1;
    }
}
