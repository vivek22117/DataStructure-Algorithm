package com.ds.algo.examples.aws.interview;

import java.util.HashSet;

public class SortSpecial {

    private static int A = 49;

    public static Integer addNumbers(int N) {
        int counter = 0;
        if(N == 4 || N == 5) {
            return 1;
        }

        while(N > 0) {
            if(N % 5 == 0) {
                if(N % 10 != 5) {
                    counter += N / 5;
                    break;
                } else {
                    counter++;
                }
            } else if(N % 4 == 0) {
                if( N % 10 != 4) {
                    counter += N / 4;
                    break;
                } else {
                    counter++;
                }
            } else {
                N = N -4;
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        Integer result = addNumbers(A);
        System.out.println(result);
    }

}
