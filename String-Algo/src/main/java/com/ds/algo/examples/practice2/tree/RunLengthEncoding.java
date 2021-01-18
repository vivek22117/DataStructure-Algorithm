package com.ds.algo.examples.practice2.tree;

public class RunLengthEncoding {

    private static String inputData = "aaaaacccdddduuuueeeeseeen";

    public static void main(String[] args) {
        String encodedString = encodeInputData(inputData);
        System.out.println(encodedString);
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
