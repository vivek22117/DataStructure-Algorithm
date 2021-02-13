package com.ds.algo.examples.practice3;

public class RunLengthEncoding {

    private static String input = "aaabbbbdddddhhhhe";

    public static void main(String[] args) {
        String encodedString = encodeRunLength(input);
        System.out.println(encodedString);
    }

    private static String encodeRunLength(String input) {
        if(input.length() == 0) {
            return "";
        }

        int index = 0;
        StringBuilder sb  = new StringBuilder();
        while(index < input.length()) {
            char ch = input.charAt(index);

            int tempIndex = index;
            int count = 0;
            while (tempIndex < input.length() && input.charAt(tempIndex) == ch){
                count += 1;
                tempIndex++;
            }

            sb.append(count);
            sb.append(ch);
            index = tempIndex;
        }
        return sb.toString();
    }

}
