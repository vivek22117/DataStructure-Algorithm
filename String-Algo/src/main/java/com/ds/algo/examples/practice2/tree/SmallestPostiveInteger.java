package com.ds.algo.examples.practice2.tree;

import java.util.Arrays;

public class SmallestPostiveInteger {

//    private static int[] data = {1,3,6,4,1,2};
//    private static int[] data = {1,2,3};
    private static int[] data = {-1,-2,-3};
    public static void main(String[] args) {
        SmallestPostiveInteger smallestPostiveInteger = new SmallestPostiveInteger();

        int solution = smallestPostiveInteger.solution(data);
        System.out.println(solution);
    }


    public int solution(int[] A) {
        Arrays.sort(A);

        if(A[A.length - 1] < 0) {
            return 1;
        }
        int i = 0;
        int smallestInt = Integer.MAX_VALUE;
        while (i < A.length - 1){
            if(A[i + 1] - A[i] > 1) {
                smallestInt = Math.min(smallestInt, A[i] + 1);
            }
            i++;
        }

        return smallestInt == Integer.MAX_VALUE ? A[A.length -1] + 1 : smallestInt;
    }
}
