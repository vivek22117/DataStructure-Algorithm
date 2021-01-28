package com.ds.algo.examples.practice1.queue;

import java.lang.reflect.Array;

public class CircularQueue<T> {

    private static final Integer SPECIAL_EMPTY_VALUE = -1;
    private static final Integer SIZE = 55;

    private T[] elements;

    private int tailIndex = SPECIAL_EMPTY_VALUE;
    private int headIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz,SIZE);
    }

    public CircularQueue(Class<T> clazz, int size) {
        elements = (T[]) Array.newInstance(clazz, size);
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex =  (tailIndex + 1) % elements.length;
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
