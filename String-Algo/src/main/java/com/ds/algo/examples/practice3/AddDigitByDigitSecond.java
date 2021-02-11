package com.ds.algo.examples.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddDigitByDigitSecond {

    private static int[] num1 = {5, 8, 9, 8};
    private static int[] num2 = {3, 7, 8};

    public static void main(String[] args) {
        int[] sum = addNumDigitByDigit(num1, num2);

        Stream.iterate(0, e -> e + 1).limit(sum.length).forEach(e -> {
            System.out.print(sum[e]);
        });
        System.out.println();
    }

    private static int[] addNumDigitByDigit(int[] num1, int[] num2) {
        List<Integer> numberSum = new ArrayList<>();

        if (num1.length == 0) {
            return num2;
        }
        if (num2.length == 0) {
            return num1;
        }

        int num1LastIndex = num1.length - 1;
        int num2LastIndex = num2.length - 1;

        int total = 0;
        int carry = 0;
        int digit = 0;

        while (num1LastIndex >= 0 && num2LastIndex >= 0) {
            total = num1[num1LastIndex] + num2[num2LastIndex] + carry;
            carry = total / 10;
            digit = total % 10;

            numberSum.add(0, digit);
            num1LastIndex--;
            num2LastIndex--;
        }

        while (num1LastIndex >= 0) {
            total = num1[num1LastIndex] + carry;
            carry = total / 10;
            digit = total % 10;

            numberSum.add(0, digit);
            num1LastIndex--;
        }

        while (num2LastIndex >= 0) {
            total = num2[num2LastIndex] + carry;
            carry = total / 10;
            digit = total % 10;

            numberSum.add(0, digit);
            num2LastIndex--;
        }

        if(carry != 0) {
            numberSum.add(0, carry);
        }

        int[] sum = new int[numberSum.size()];
        Stream.iterate(0, e -> e + 1).limit(numberSum.size()).forEach(e -> {
            sum[e] = numberSum.get(e);
        });


        return sum;
    }
}
