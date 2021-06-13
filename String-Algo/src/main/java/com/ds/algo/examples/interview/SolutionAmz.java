package com.ds.algo.examples.interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here

        List<List<String>> output = new ArrayList<>();
        HashMap<String, List<String>> searchWords = new HashMap<>();

        for(int i = 1; i < customerQuery.length(); i++) {
            String searchWord = customerQuery.substring(0, i + 1);
            searchWords.put(searchWord, new ArrayList<>());

            for(int j = 0; j < repository.size(); j++) {
                char[] searchChars = searchWord.toCharArray();
                char[] compareChars = repository.get(j).toCharArray();

                boolean isValid = true;
                for(int k = 0; k < searchChars.length && k < compareChars.length; k++) {
                    if(searchChars[k] != compareChars[k]){
                        isValid = false;
                    }
                }
                if(isValid) {
                    searchWords.get(searchWord).add(repository.get(j));
                }

            }
            if(searchWords.get(searchWord).size() > 0) {
                output.add(searchWords.get(searchWord).stream().sorted().limit(3).collect(Collectors.toList()));
            } else {
                output.add(new ArrayList<>());
            }

        }

        for(List<String> value: searchWords.values()){
            System.out.println(value);
        }

        // output.addAll(searchWords.values());
        return output;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\projects\\Development\\DataStructure-Algorithm\\data\\"));

        int repositoryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> repository = IntStream.range(0, repositoryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String customerQuery = bufferedReader.readLine();

        List<List<String>> result = Result.searchSuggestions(repository, customerQuery);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

