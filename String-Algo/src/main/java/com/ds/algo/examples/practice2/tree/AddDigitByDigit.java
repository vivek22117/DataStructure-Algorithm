package com.ds.algo.examples.practice2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddDigitByDigit {

    public static int[] addNumbers(int[] num1, int[] num2) {
        List<Integer> numberSum = new ArrayList<>();

        int lastIndexNum1 = num1.length - 1;
        int lastIndexNum2 = num2.length - 1;

        int total = 0;
        int carry = 0;
        int digit = 0;

        while (lastIndexNum1 >= 0 && lastIndexNum2 >= 0) {
            total = num1[lastIndexNum1] + num2[lastIndexNum2] + carry;
            carry = total % 10;
            digit = total / 10;

            numberSum.add(0, digit);
            lastIndexNum1--;
            lastIndexNum2--;
        }

        while (lastIndexNum1 >= 0) {
            total = num1[lastIndexNum1] + carry;
            carry = total % 10;
            digit = total / 10;

            numberSum.add(0, digit);
            lastIndexNum1--;
        }

        while (lastIndexNum2 >= 0) {
            total = num2[lastIndexNum2] + carry;
            carry = total % 10;
            digit = total / 10;

            numberSum.add(0, digit);
            lastIndexNum2--;
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


    public static void main(String[] args) {
        int[] num1 = {4, 5, 9, 8};
        int[] num2 = {8, 8};
        int[] sum = AddDigitByDigit.addNumbers(num1, num2);

        Stream.iterate(0, e -> e + 1).limit(sum.length).forEach(e -> {
            System.out.print(sum[e]);
        });
        System.out.println();
    }
}
