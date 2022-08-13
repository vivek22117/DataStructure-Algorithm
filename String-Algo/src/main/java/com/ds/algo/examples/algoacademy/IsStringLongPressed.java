package com.ds.algo.examples.algoacademy;


/*
Input:
input: "vivek"
Long Pressed input: "viiiveeeekkk"

Output: True

 */
public class IsStringLongPressed {

    private static String input = "vivekk";
    private static String longPressedInput = "viiivve";

    public static void main(String[] args) {
        IsStringLongPressed longPressed = new IsStringLongPressed();
        boolean result = longPressed.isLongPressedInput(input, longPressedInput);

        System.out.println(result);
    }


    public boolean isLongPressedInput(String input, String longPressedInput) {
        int n = input.length();                                                 // 2
        int m = longPressedInput.length();                                      // 4

        if(m < n) {
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < n && j < m) {                                                 // i < 2 && j < 4
            char ch1 = input.charAt(i);                                         // v i
            char ch2 = longPressedInput.charAt(j);                              // v i

            if(ch1 != ch2) {
                return false;
            }

            int a = i + 1;                                                      // 1   2
            int b = j + 1;                                                      // 1   2  3

            while (a <= input.length() -1  && input.charAt(a) == ch1) {
                a++;
            }

            while (b <= longPressedInput.length() - 1 && longPressedInput.charAt(b) == ch2) {
               b++;
            }

            i = a;
            j = b;
        }

        return true;
    }

    private static boolean isLongPressedName(String input_a, String input_b) {
        int m = input_a.length();
        int n = input_b.length();

        if(m < n ) {
            return  false;
        }

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            char ch_a = input_a.charAt(i);
            char ch_b = input_b.charAt(j);

            if(ch_a != ch_b) {
                return false;
            }

            int a = i + 1;
            int b = j + 1;
            while (a <= input_a.length() - 1 && input_a.charAt(a) == ch_a) {
                a++;
            }

            while (b <= input_b.length() - 1 && input_b.charAt(b) == ch_b) {
                b++;
            }

            i = a;
            j = b;
        }

        return true;
    }
}
