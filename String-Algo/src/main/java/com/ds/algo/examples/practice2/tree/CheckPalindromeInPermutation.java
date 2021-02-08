package com.ds.algo.examples.practice2.tree;

public class CheckPalindromeInPermutation {

    private static String input = "Tact Coa";

    public static void main(String[] args) {
        boolean palindrome = CheckPalindromeInPermutation.isPalindrome(input);
        System.out.println("Is Palindrome in permutation: " + palindrome);
    }

    private static boolean isPalindrome(String input) {
        if(input.length() == 0) {
            return false;
        }
        int[] tracker = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        int countOdd = 0;
        for(int i = 0; i < input.length(); i++) {
            int characterNumber = getCharacterNumber(input.charAt(i));
            if(characterNumber != -1) {
                tracker[characterNumber]++;

                if(tracker[characterNumber] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int getCharacterNumber(char ch) {
        int charValue = Character.getNumericValue(ch);

        int z = Character.getNumericValue('z');
        int a = Character.getNumericValue('a');

        if(a <= charValue && charValue <= z) {
            return charValue - a;
        }
        return -1;
    }
}
