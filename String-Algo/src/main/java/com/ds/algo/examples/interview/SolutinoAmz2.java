package com.ds.algo.examples.interview;

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


class Result2 {

    /*
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codeList
     *  2. STRING_ARRAY shoppingCart
     */

    public static int foo(List<String> codeList, List<String> shoppingCart) {
        // Write your code here
        List<String> dataList = codeList.stream().map(x -> Stream.of(x.split(" ")).collect(Collectors.toList()))
                .collect(Collectors.toList()).stream().flatMap(Collection::stream).collect(Collectors.toList());


        if(dataList.size() != shoppingCart.size()){
            return 0;
        } else {
            for(int i = 0; i < dataList.size(); i++) {
                for(int j = 0; j < shoppingCart.size(); j++) {
                    if(dataList.get(i) == shoppingCart.get(j)) {
                        boolean isGrouped = process(dataList, shoppingCart, i, j);
                    }
                }
            }
        }

        return 0;
    }

    private static boolean process(List<String> data, List<String> cart, int i, int j) {



        return true;
    }

}
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codeListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> codeList = IntStream.range(0, codeListCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int shoppingCartCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> shoppingCart = IntStream.range(0, shoppingCartCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result2.foo(codeList, shoppingCart);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

