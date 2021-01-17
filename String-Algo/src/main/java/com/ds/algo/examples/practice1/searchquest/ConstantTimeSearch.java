package com.ds.algo.examples.practice1.searchquest;

import java.util.Stack;

public class ConstantTimeSearch {

    private static final Stack<Integer> dataStack = new Stack<>();
    private static final Stack<Integer> minimumElementStack = new Stack<>();

    public static void main(String[] args) {
        pushData(5);
        pushData(11);
        pushData(7);

        System.out.println(getMinimumElement());
    }

    private static void pushData(int value) {
        int min = value;
        if(!minimumElementStack.isEmpty()) {
            if(minimumElementStack.peek() < min) {
                min = minimumElementStack.peek();
            }
        }
        dataStack.push(value);
        minimumElementStack.push(min);
    }

    public static Integer getMinimumElement(){
        return minimumElementStack.peek();
    }

    public static void popData(){
        minimumElementStack.pop();
        dataStack.pop();
    }
}
