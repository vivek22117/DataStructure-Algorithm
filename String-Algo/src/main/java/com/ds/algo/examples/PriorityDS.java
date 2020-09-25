package com.ds.algo.examples;

import java.util.Stack;

public class PriorityDS {

    private static Stack<Employee> highPriorityElements = new Stack<>();
    private static Stack<Employee> elements = new Stack<>();

    public static class Employee {
        String name;
        Integer priority;

        public Employee(String name, Integer priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    private static void putElement(Employee arun) {
        Employee priority = arun;

        if(!highPriorityElements.isEmpty()) {
            if(arun.priority < highPriorityElements.peek().priority){
                priority = highPriorityElements.peek();
            }
        }
        highPriorityElements.push(priority);
        elements.push(arun);
    }

    private static Employee getElement() {
        return highPriorityElements.pop();
    }



    public static void main(String[] args) {
    }
}
