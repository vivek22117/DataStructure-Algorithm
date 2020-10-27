package com.ds.algo.examples.searchquest;

public class SumOfNumberInString {

    private static final String inputData = "a5icssd1adfix2f";

    public static void main(String[] args) {

        int sumOfNumber = findSumOfNumber(inputData);
        System.out.println(sumOfNumber);
    }

    private static int findSumOfNumber(String inputData) {
        if(inputData.length() == 0) {
            return 0;
        }

        int N = inputData.length();
        int sum = 0;
        int count = 0;
        boolean isDigit = false;

        for(int i = 0; i< N; i++){
            if(Character.isDigit(inputData.charAt(i))){
                count = count + 1;
                isDigit = true;
            } else {
                if(isDigit) {
                    sum = sum + Integer.parseInt(inputData.substring(i - count, i));
                    isDigit = false;
                    count = 0;
                }
            }
        }
        if(count > 0 || isDigit) {
            sum = sum + Integer.parseInt(inputData.substring(N - count, N));
        }
        return sum;
    }
}
