package com.ds.algo.examples.algoacademy;

public class ReverseString {

    private static String input = "Hi I am Vivek";

    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();
        String output = reverse.reverse(input);
        System.out.println(output);
    }

    public String reverse(String data) {
        char[] characters = data.toCharArray();

        int left = 0;
        int right = characters.length -1;

        while(left < right) {
            char ch = characters[right];
            characters[right] = characters[left];
            characters[left] = ch;

            left++;
            right--;
        }

        return new String(characters);
    }
}
