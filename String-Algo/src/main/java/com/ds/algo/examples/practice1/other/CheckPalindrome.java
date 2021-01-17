package com.ds.algo.examples.practice1.other;

public class CheckPalindrome {

    private static final String input = "Malayalam";

    public static void main(String[] args) {
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        boolean palindrome = checkPalindrome.isPalindrome(input);

        System.out.println("Is Palindrome: " + palindrome);
    }

    private boolean isPalindrome(String input) {
        if(input.length() == 0) {
            return false;
        }
        input = input.toLowerCase();
        int forwardIndx = 0;
        int backwardIndx = input.length() -1;

        while (forwardIndx < backwardIndx) {
            char forwardChar = input.charAt(forwardIndx);
            char backwardChar = input.charAt(backwardIndx);

            if(forwardChar != backwardChar) {
                return false;
            }
            forwardIndx++;
            backwardIndx--;
        }
        return true;
    }
}
