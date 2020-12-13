package com.ds.algo.examples;

public class FindOneEditPalindrome {

    public static String inputData = "acdcio";

    public static void main(String[] args) {
        String validOneEditPalindrome = isValidOneEditPalindrome(inputData);
        System.out.println(validOneEditPalindrome);
    }

    private static String isValidOneEditPalindrome(String inputData) {
        if(inputData.length() == 0) {
            return "NO";
        }
        if(inputData.length() == 1) {
            return "YES";
        }

        int fwdIndex = 0;
        int bwdIndex = inputData.length() - 1;
        String isValid = "YES";
        int countInValid = 0;

        while (fwdIndex < bwdIndex) {
            if (inputData.charAt(fwdIndex) != inputData.charAt(bwdIndex)) {
                countInValid = countInValid + 1;
            }
            fwdIndex++;
            bwdIndex--;

            if(countInValid > 1) {
                isValid = "NO";
                break;
            }
        }

        return isValid;
    }
}
