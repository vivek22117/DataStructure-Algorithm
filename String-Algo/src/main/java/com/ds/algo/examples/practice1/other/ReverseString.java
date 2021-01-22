package com.ds.algo.examples.practice1.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

    private static String inputString = "My name is Vivek";
    private static Integer data = 125;

    //keviv si eman yM
    //125
    //

    public static void main(String[] args) {
        int[] result = new int[3];
        int count = 0;
//        reverseString(inputString);
        reverseInteger(data, result, count);
    }

    private static int[] reverseInteger(Integer data, int[] result, int count) {
        int size = String.valueOf(data).length();

        int temp = data % 10;
        System.out.println(temp);
        int nextValue = data / 10;
        System.out.println(nextValue);

        result[count] = temp;
        count++;
        if(count == size) {
            IntStream.of(result).forEach(System.out::print);
            return result;
        }
        reverseInteger(nextValue, result, count);
        IntStream.of(result).forEach(System.out::print);

//        data.stream().collect(Collectors.toMap(data.deparmentId, LOGIC , Collectors.toList()))
        return result;
    }

    private static String reverseString(String inputString) {
        if(inputString == null ){
            return null;
        }

        int forwardIndex = 0;
        int backwardIndex = inputString.length() - 1;
        StringBuilder result = new StringBuilder();
        while (backwardIndex >= forwardIndex) {

            result.append(inputString.charAt(backwardIndex));

            backwardIndex--;
        }
        System.out.println(result.toString());
        return null;
    }
}
