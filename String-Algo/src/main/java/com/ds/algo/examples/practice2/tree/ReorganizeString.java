package com.ds.algo.examples.practice2.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    private static String data = "aaab";


    public static String organizeString(String inputData) {
        if(inputData.length() == 1) {
            return inputData;
        }

        HashMap<Character, Integer> count = new HashMap<>();
        for(char ch : inputData.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count.get(o2) - count.get(o1);
            }
        });

        maxHeap.addAll(count.keySet());

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char charFirst = maxHeap.remove();
            char charSecond = maxHeap.remove();
            sb.append(charFirst);
            sb.append(charSecond);

            count.put(charFirst, count.get(charFirst) - 1);
            count.put(charSecond, count.get(charSecond) - 1);

            if(count.get(charFirst) > 0) {
                maxHeap.add(charFirst);
            }
            if(count.get(charSecond) > 0) {
                maxHeap.add(charSecond);
            }
        }

        if(!maxHeap.isEmpty()) {
            char lastChar = maxHeap.remove();
            if(count.get(lastChar) > 1) {
                return "";
            }

            sb.append(lastChar);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = organizeString(data);
        System.out.println(s);
    }
}
