package com.ds.algo.examples.linklist;

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
}
