package com.ds.algo.examples.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddDigitByDigitSecond {

    private static int[] num1 = {5, 8, 9, 8};
    private static int[] num2 = {3, 7, 8};

    public static void main(String[] args) {
        addNumDigitByDigit(num1, num2);
    }

    private static int[] addNumDigitByDigit(int[] num1, int[] num2) {
        List<Integer> numberSum = new ArrayList<>();

        if (num1.length == 0) {
            return num2;
        }
        if (num2.length == 0) {
            return num1;
        }


        int[] sum = new int[numberSum.size()];
        Stream.iterate(0, e -> e + 1).limit(numberSum.size()).forEach(e -> {
            sum[e] = numberSum.get(e);
        });


        return sum;
    }
}
