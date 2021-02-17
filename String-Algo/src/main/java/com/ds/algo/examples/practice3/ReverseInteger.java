package com.ds.algo.examples.practice3;

public class ReverseInteger {

    private static int value = 435576;

    public static void main(String[] args) {
        int i = reverseInt(value);
        System.out.println(i);
    }

    private static int reverseInt(int value) {
        long result = 0;
        while (value != 0) {
            int remainder = value % 10;
            result = result * 10 + remainder;

            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

            value /= 10;
        }

        return (int) result;
    }
}
