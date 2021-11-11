package com.ds.algo.examples.algoacademy;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
===========================================================
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

==============================================================
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    private static String[] wordList = {"hot","dot","dog","lot","log","cog"};

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        int result = ladder.ladderLength(wordList, "hit", "cog");
        System.out.println(result);
    }

    public int ladderLength(String[] words, String beginWord, String endWord) {
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> minDistMap = new HashMap<>();

        queue.add(beginWord);
        minDistMap.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();

            if(endWord.equals(word)){
                break;
            }

            for(String nextWord : words) {
                if(numOfChanges(word, nextWord) != 1) {
                    continue;
                }
                if(minDistMap.containsKey(nextWord)) {
                    continue;
                }
                minDistMap.put(nextWord, minDistMap.get(word) + 1);
                queue.add(nextWord);
            }
        }
        return minDistMap.getOrDefault(endWord, 0);
    }

    private int numOfChanges(String word, String nextWord) {
        int diff = 0;

        for(int i = 0; i < word.length(); i++) {
            diff += (word.charAt(i) != nextWord.charAt(i)) ? 1 : 0;
        }

        return diff;
    }

}
