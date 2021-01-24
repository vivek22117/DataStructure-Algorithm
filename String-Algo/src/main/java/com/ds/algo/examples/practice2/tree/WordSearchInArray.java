package com.ds.algo.examples.practice2.tree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchInArray {

    public boolean isWordExist(List<Character[]> inputData, String word) {
        for (int i = 0; i < inputData.size(); i++) {
            for (int j = 0; j < inputData.get(i).length; j++) {
                if (inputData.get(i)[j] == word.charAt(0) && dfs(inputData, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(List<Character[]> inputData, int i, int j, int count, String word) {
        if (word.length() == count) {
            return true;
        }

        if (i < 0 || i >= inputData.size() || j < 0 || j >= inputData.get(i).length
                || inputData.get(i)[j] != word.charAt(count)) {
            return false;
        }

        char temp = inputData.get(i)[j];
        inputData.get(i)[j] = ' ';

        boolean found = dfs(inputData, i, j + 1, count + 1, word) ||
                dfs(inputData, i, j -1, count +1, word) ||
                dfs(inputData, i + 1, j, count + 1, word) ||
                dfs(inputData, i -1, j, count + 1, word);

        inputData.get(i)[j] = temp;
        return found;
    }

    public static void main(String[] args) {
        Character[] charArray1 = {'A', 'B', 'C', 'E'};
        Character[] charArray2 = {'S', 'F', 'C', 'S'};
        Character[] charArray3 = {'A', 'D', 'E', 'E'};
        List<Character[]> dataList = new ArrayList<>();
        dataList.add(charArray1);
        dataList.add(charArray2);
        dataList.add(charArray3);

        WordSearchInArray wordSearchInArray = new WordSearchInArray();
        boolean see = wordSearchInArray.isWordExist(dataList, "SEE");
        System.out.println(see);
    }
}
