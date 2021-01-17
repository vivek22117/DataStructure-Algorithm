package com.ds.algo.examples.practice1.other;

import java.lang.reflect.Array;

public class PriorityDS<T> {

    private Integer MAX_SIZE = 10;
    private static Integer SIZE = 0;

    private T[] elements;

    public PriorityDS(Class<T> clazz) {
        this.elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public boolean isEmpty() {
        return SIZE == 0;
    }

    public void putElement(T element){
        if(SIZE == elements.length) {
            return;
        }
        elements[SIZE] = element;
        rearrangeElements(SIZE);
        SIZE++;
    }

    private void rearrangeElements(Integer index) {
       int nextIndx = index + 1;

        if(nextIndx != SIZE - 1) {
            if(compareElements(elements[index], elements[nextIndx]) < 0){
                swap(nextIndx, index);
                rearrangeElements(nextIndx);
            }
        }
    }

    private void shiftElements(Integer index) {
        int previousIndx = index - 1;

        if(previousIndx != -1) {
            if(compareElements(elements[index], elements[previousIndx]) > 0) {
                swap(previousIndx, index);
                shiftElements(previousIndx);
            }
        }
    }

    private void swap(int index, Integer previousIndx) {
        T element = elements[previousIndx];
        elements[previousIndx] = elements[index];
        elements[index] = element;
    }

    private int compareElements(T element1, T element2) {

        return -1;
    }

    public T getElement() {
        if(isEmpty()) {
            return null;
        }
        T priorityElement =  elements[0];
        elements[0] = elements[SIZE - 1];
        SIZE--;
        rearrangeElements(0);

        return priorityElement;
    }

    public static class Employee implements Comparable<Employee> {
        String name;
        Integer priority;

        public Employee(String name, Integer priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Employee o) {
            return this.priority - o.priority;
        }
    }

    public static void main(String[] args) {
        PriorityDS<Employee> ds = new PriorityDS<>(Employee.class);

        putNewElement(ds, new Employee("Arun", 8));
        getElement(ds);
    }

    private static Employee getElement(PriorityDS<Employee> ds) {
        return ds.getElement();
    }

    private static void putNewElement(PriorityDS<Employee> ds, Employee arun) {
        ds.putElement(arun);
    }

}
