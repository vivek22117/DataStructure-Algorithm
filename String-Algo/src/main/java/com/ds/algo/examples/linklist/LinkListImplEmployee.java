package com.ds.algo.examples.linklist;

import com.ds.algo.examples.util.AppUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LinkListImplEmployee {
    LinkListDS<Employee> employeeLinkListDS = new LinkListDS<>();

    public class Employee {

        private String name;
        private String address;
        private Long salary;

        public Employee(String name, String address, Long salary) {
            this.name = name;
            this.address = address;
            this.salary = salary;
        }

    }

    public LinkListDS<Employee>.Node<Employee> getFirstEmployee(){
       return employeeLinkListDS.getHead();
    }

    public boolean isEmployeeListEmpty() {
        return employeeLinkListDS.isEmpty();
    }

    public void addEmployee(Employee employee) {
        employeeLinkListDS.addNode(employee);
    }

    public Employee deleteEmployeeFromBeginningOfTheList() {
        return employeeLinkListDS.deleteNodeInBeginning();
    }

    public Employee deleteSpecificEmployee(Employee employee) {
        return employeeLinkListDS.deleteSpecificNode(employee);
    }

    public void removeDuplicateElements() {
        removeDuplicates(employeeLinkListDS.getHead()) ;
    }

    private void removeDuplicates(LinkListDS<Employee>.Node<Employee> head) {
    }

    public List<Employee> populateEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        IntStream.iterate(0, e -> e +1).limit(22).forEach(value -> {
            int randomNum = AppUtility.getRandomNum(55, 11, 22);
            employeeList.add(new Employee("A " + randomNum, "Pune", (long) randomNum));
        });

        return employeeList;
    }
}
