package com.ds.algo.examples.practice2.tree;

import java.util.Arrays;

public class CompressCharArray {
    private static char[] chars = {'a', 'c', 'd', 'd', 'd', 'd', 'i'};

    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]){
                j++;
            }
            chars[index++] = chars[i];
            if(j - i > 1) {
                String count = j - i + "";
                for (char ch : count.toCharArray()){
                    chars[index++] = ch;
                }
            }
            i = j;
        }
        System.out.println(Arrays.toString(chars));
        return index;
    }

    public static void main(String[] args) {
        int compress = compress(chars);
        System.out.println(compress);
    }
}
