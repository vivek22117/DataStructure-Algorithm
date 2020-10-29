package com.ds.algo.examples.linklist;

import com.ds.algo.examples.util.AppUtility;

import java.util.stream.IntStream;

public class LinkListOperations {
    LinkListDS<Machine> employeeList = null;

    public class Machine {

        private String name;
        private String loc;
        private Long id;

        public Machine(String name, String loc, Long id) {
            this.name = name;
            this.loc = loc;
            this.id = id;
        }
    }

    public LinkListDS<Machine> populateEmployees() {
        employeeList = new LinkListDS<>();

        IntStream.iterate(0, e -> e + 1).limit(22).forEach(value -> {
            int randomNum = AppUtility.getRandomNum(55, 11, 22);
            employeeList.addNode(new Machine("A " + randomNum, "Pune", (long) randomNum));
        });

        return employeeList;
    }

    public static void main(String[] args) {
        LinkListOperations ls = new LinkListOperations();
        ls.populateEmployees();
        Machine linkListHead = ls.getLinkListHead();

        boolean emptyList = ls.isEmptyList();
        System.out.println(emptyList);

    }

    private boolean isEmptyList() {
        return employeeList.isEmpty();
    }

    private Machine getLinkListHead() {
        return employeeList.getHead();
    }
}
