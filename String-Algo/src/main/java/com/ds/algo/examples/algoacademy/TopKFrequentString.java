package com.ds.algo.examples.algoacademy;


import java.util.*;

/*
Input:
["i", "leetcode", "love", "leet", "i", "code", "code", "leet"]

Output: []

 */
public class TopKFrequentString {
    private static String[] input = {"i", "leetcode", "love", "leet", "i", "code", "code"};

    public static void main(String[] args) {
        TopKFrequentString frequency = new TopKFrequentString();
        List<String> result = frequency.topKString(input, 2);
        System.out.println(result);
    }

    public List<String> topKString(String[] data, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String value : data) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int freq1 = map.get(s1);
                int freq2 = map.get(s2);

                if(freq1 == freq2) {
                    return s2.compareTo(s1);
                }
                return freq1 - freq2;
            }
        });


        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
