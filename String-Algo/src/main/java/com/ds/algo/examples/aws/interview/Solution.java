package com.ds.algo.examples.aws.interview;

public class Solution {

    private int[] data = {-1,1,3,3,3,2,3,2,1,0};

    //

//    public int solution(int[] A) {
//        if(A.length < 3) {
//            return 0;
//        }
//
//        int N = A.length;
//
//        int counter = 0;
//
//        for(int i = 0; i < N; i++) {
//            for(int count = 0; i + 2 < N && A[i + 1] - A[i] == A[i + 2] - A[i+1]; i++){
//                    counter += ++count;
//            }
//        }
//
//        return counter < 1000000000 ? counter : -1;
//
////        while (p1 < N - 3) {
////            int currentDiff = Math.abs(A[p2]) - Math.abs(A[p1]);
////
////            if(p2 - p1 >= 2) {
////                counter += 1;
////            }
////
////            if(Math.abs(A[p2 + 1]) - Math.abs(A[p1 + 1]) == currentDiff) {
////
////            }
////        }
//
//    }

    public int solution(int N) {
        int replaceNum = 5;
        if(N == 0) {
            return 50;
        }

        int max = Integer.MIN_VALUE;
        int neg = N / Math.abs(N);
        int counter = 0;
        int position = 1;
        while (N > 0) {
            counter++;
            N = N / 10;
        }

        for(int i = 0; i <= counter; i++) {
            int temp = ((N/position) * (position * 10)) + (replaceNum * position) + (N % position);

            if(temp * neg > max) {
                max = temp + neg;
            }
            position = position + 10;
        }
        return max;
    }
}
