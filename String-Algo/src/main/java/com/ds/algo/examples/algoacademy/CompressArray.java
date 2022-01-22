package com.ds.algo.examples.algoacademy;


import java.util.Arrays;

/*
Input: nums = ['a', 'c', 'd', 'd', 'd', 'd', 'i']
Output: Length of array after compress 5, [a,c,d,4,i]

 */
public class CompressArray {

    private static char[] chars = {'a', 'a', 'c', 'd', 'd', 'd', 'd', 'i'};

    public static void main(String[] args) {
        CompressArray compress = new CompressArray();
        int result = compress.compress(chars);
        System.out.println(result);
    }

    private int compress(char[] chars) {
        if(chars.length == 0) {
            return -1;
        }

        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == ch) {
                j++;
            }
            int count = j - i;
            chars[index++] = ch;
            if(count > 1) {
                String value = count + "";
                for(char val : value.toCharArray()) {
                    chars[index++] = val;
                }
            }
            i = j;
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
        return index;
    }


    private  int compressCharArray(char[] chars) {
        if(chars.length == 0) {
            return -1;
        }

        int index  = 0;
        int i = 0;
        while(i < chars.length) {
            char ch = chars[i];
            int j = i;

            while (j < chars.length && chars[j] == ch) {
                j++;
            }

            int count = j - 1;
            chars[index++] = ch;
            if(count > 1) {
                String value = count + "";
                char[] values = value.toCharArray();
                for(char val : values) {
                    chars[index++] = val;
                }
            }

            i = j;
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, index)));
        return index;
    }
}
