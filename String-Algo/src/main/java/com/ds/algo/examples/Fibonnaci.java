package com.ds.algo.examples;

//Runtime O(n) & Space O(1)
public class Fibonnaci {

    private int getFibonnaci(int k) {
        if(k <= 1) {
            return k;
        }


        int first = 1;
        int second = 0;
        int result = 0;

        for(int i = 1; i < k; i++) {
            result = first + second;
            second = first;
            first = result;
        }

        return result;
    }


    public static void main(String[] args) {
        Fibonnaci fibonnaci = new Fibonnaci();
        int number = fibonnaci.getFibonnaci(6);
        System.out.println(number);
    }
}
