package com.ds.algo.examples.practice2.tree;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharIndex {

    private static String inputData = "leetCodeirl";

    public static void main(String[] args) {
        int i = firstUniqChar(inputData);
        System.out.println("Index is: " + i);
    }


    public static int firstUniqChar(String inputData) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < inputData.length(); i++) {
            char ch = inputData.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
            } else {
                map.put(ch, -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char ch : map.keySet()) {
            if(map.get(ch) > -1 && map.get(ch) < min) {
                min = map.get(ch);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
