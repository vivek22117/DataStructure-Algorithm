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


class Result11 {

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> result = new ArrayList<>();
        int count = 0;

        int[] values = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                values[i] = count;
            } else {
                ++count;
            }
        }


        for(int j = 0; j < startIndices.size(); j++) {
            int startInx = startIndices.get(j) - 1;
            int endInx = endIndices.get(j) - 1;

            while(startInx < endInx && s.charAt(startInx) != '|') {
                ++startInx;
            }

            while(startInx < endInx && s.charAt(endInx) != '|') {
                --endInx;
            }

            result.add(values[endInx] - values[startInx]);
        }
        return result;
    }

}
class Solution11 {
    public static void main(String[] args) throws IOException {
        String s = "|**|*|*";
        List<Integer> startIndices = Arrays.asList(1, 1);
        List<Integer> endIndices = Arrays.asList(5, 6);


        Result11.numberOfItems(s, startIndices, endIndices);

    }
}
