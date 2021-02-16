package com.ds.algo.examples.practice2.tree;

import java.util.stream.IntStream;

public class RunLengthEncoding {

    private static String inputData = "aaaaaaaaaaaaaaaaaaacccdddduuuueeeeseeen";

    public static void main(String[] args) {
        String encodedString = encodeInputData(inputData);
        System.out.println(encodedString);

        decodeInputData(encodedString);
    }

    private static String decodeInputData(String encodedString) {
        if(encodedString.length() == 0) {
            return null;
        }

        int startIndex = 0;
        int endIndex = 1;
        StringBuilder sb = new StringBuilder();
        while (endIndex < encodedString.length()) {
            if(Character.isDigit(encodedString.charAt(endIndex))){
                endIndex += 1;
            }

            String tempData = encodedString.substring(startIndex, endIndex);
            Integer value = Integer.valueOf(tempData);
            char ch = encodedString.charAt(endIndex);
            IntStream.iterate(0, e -> e + 1).limit(value).forEach(e -> {
                sb.append(ch);
            });

            startIndex = endIndex + 1;
            endIndex = startIndex + 1;
        }

        return sb.toString();
    }

    private static String encodeInputData(String inputData) {
        if(inputData.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        while (startIndex < inputData.length()) {
            char ch = inputData.charAt(startIndex);

            int tempIndex = startIndex;
            int count = 0;
            while (tempIndex < inputData.length() && inputData.charAt(tempIndex) == ch) {
                tempIndex += 1;
                count += 1;
            }

            sb.append(count);
            sb.append(ch);
            startIndex = tempIndex;
        }
        return sb.toString();
    }
}
