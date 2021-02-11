package com.ds.algo.examples.practice3;

public class CheckPalindromeInPermuSecond {

    private static String inputData = "Tact Coa";

    public static void main(String[] args) {
        isPalindromeInPermu(inputData);
    }

    private static boolean isPalindromeInPermu(String inputData) {
        if(inputData.length() == 0){
            return false;
        }

        int[] charArray = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        int countOdd = 0;

        for(char ch : inputData.toCharArray()) {
            int x = getCharacterNum(ch);
        }

        return false;
    }

    private static int getCharacterNum(char ch) {
        int value = Character.getNumericValue(ch);

        int z = Character.getNumericValue('z');
        int a = Character.getNumericValue('a');

        if(a <= value && z >= value) {
            return value - a;
        }
        return -1;
    }
}
