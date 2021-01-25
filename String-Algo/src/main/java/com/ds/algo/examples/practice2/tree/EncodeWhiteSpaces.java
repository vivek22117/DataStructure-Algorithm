package com.ds.algo.examples.practice2.tree;

import java.util.Arrays;

public class EncodeWhiteSpaces {

    public static char[] encodeWhiteSpace(char[] str) {

        int countWhiteSpaces = 0;

        for(int i = 0; i < str.length; i++) {
            if(Character.isWhitespace(str[i])) {
                countWhiteSpaces++;
            }
        }

        if(countWhiteSpaces > 0) {
            char[] encodedStr = new char[str.length + countWhiteSpaces * 2];

            int index = 0;
            for(int i = 0; i< str.length; i++) {
                if(Character.isWhitespace(str[i])){
                    encodedStr[index] = '%';
                    encodedStr[index + 1] = '2';
                    encodedStr[index + 2] = '0';
                    index = index + 3;
                } else {
                    encodedStr[index] = str[i];
                    index++;
                }
            }
            return encodedStr;
        }

        return str;
    }

    public static void main(String[] args) {
        char[] data  = "  String   is the    best  ".toCharArray();
        char[] chars = EncodeWhiteSpaces.encodeWhiteSpace(data);
        System.out.print(String.valueOf(chars));
    }
}
