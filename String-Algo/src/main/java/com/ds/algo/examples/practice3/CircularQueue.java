package com.ds.algo.examples.practice3;

import java.lang.reflect.Array;

public class CircularQueue<T> {

    private static final int MAX_SIZE = 55;
    private static final int SPECIAL_EMPTY_VALUE = -1;

    private T[] element;

    private int tailIndex = SPECIAL_EMPTY_VALUE;
    private int headIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        element = (T[])Array.newInstance(clazz, MAX_SIZE);
    }

    public CircularQueue(Class<T> clazz, int size) {
        element = (T[])Array.newInstance(clazz, size);
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % element.length;
        return nextIndex == headIndex;
    }

    public static class QueueOverFlowException extends Exception {
        public QueueOverFlowException() {
            super();
        }
    }

    public static class QueueUnderFlowException extends Exception {
        public QueueUnderFlowException() {
            super();
        }
    }

}
