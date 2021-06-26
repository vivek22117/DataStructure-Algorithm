package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'howManySwaps' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long howManySwaps(List<Integer> arr) {

        if(arr.size() == 1) {
            return 0;
        }

        long swapCount = 0;

        for(int i = 0; i < arr.size(); i++) {
            int first = arr.get(i);
            for(int j = i + 1; j < arr.size(); j++) {
                if(first > arr.get(j)){
                    swap(arr, i, j);
                    swapCount += 1;
                    break;
                }
            }
        }
        return swapCount;
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> values = Arrays.asList(5,1,4,2);
        Result.howManySwaps(values);
    }
}

