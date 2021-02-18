package com.ds.algo.examples.practice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupedAnagram {

    private static String[] data = {"ate", "eat", "nat", "tan", "tea"};

    public static void main(String[] args) {
        groupAnagrams(data);
    }

    private static List<List<String>> groupAnagrams(String[] data) {
        List<List<String>> groupedAnagram = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String val : data) {
            char[] chars = val.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(val);
        }

        groupedAnagram.addAll(map.values());
        return groupedAnagram;
    }
}
