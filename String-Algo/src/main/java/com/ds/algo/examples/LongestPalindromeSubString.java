package com.ds.algo.examples;

public class LongestPalindromeSubString {

    private static final String inputData = "xhrystuutsnypo";

    public static void main(String[] args) {
        String longestSubStringPalindrome = getLongestSubStringPalindrome(inputData);
        System.out.println("LongestSubString: " + longestSubStringPalindrome);
    }

    private static String getLongestSubStringPalindrome(String inputData) {
        if(inputData.length() == 0){
            throw new RuntimeException("Please provide valid string!");
        }

        int[] currentLongest = {0, 1};
        for(int i = 0; i< inputData.length(); i++) {
            int[] oddPland = helperMethod(inputData, i - 1, i + 1);
            int [] evenPland = helperMethod(inputData, i -1, i);

            int[] tempLongest = oddPland[1] - oddPland[0] > evenPland[1] - evenPland[0] ? oddPland : evenPland;

            currentLongest = currentLongest[1] - currentLongest[0] > tempLongest[1] - tempLongest[0] ? currentLongest : tempLongest;
        }

        return inputData.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] helperMethod(String inputData, int leftIndex, int righIndex) {
        while (leftIndex >= 0 && righIndex < inputData.length()) {
            if(inputData.charAt(leftIndex) != inputData.charAt(righIndex)) {
                break;
            }
            leftIndex--;
            righIndex++;
        }

        return new int[]{leftIndex + 1, righIndex};
    }
}
