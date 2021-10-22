package com.ds.algo.examples.algoacademy;


/*
Input:
input: "vivek"
Long Pressed input: "viiiveeeekkk"

Output: True

 */
public class IsStringLongPressed {

    private static String input = "vivek";
    private static String longPressedInput = "viiiveeeeekkk";

    public static void main(String[] args) {

    }


    public boolean isLongPressedInput(String input, String longPressedInput) {
        int m = input.length();
        int n = longPressedInput.length();

        if(n < m) {
            return false;
        }


    }
}
