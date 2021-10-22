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

        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            char ch1 = input.charAt(i);
            char ch2 = input.charAt(j);

            if(ch1 != ch2) {
                return false;
            }

            int a = i + 1;
            int b = j + 1;

            while (a < n && input.charAt(a) == ch1) {
                ++a;
            }

            while (b < m && longPressedInput.charAt(b) == ch2) {
               ++b;
            }

            i = a;
            j = b;
        }

        return true;
    }
}
