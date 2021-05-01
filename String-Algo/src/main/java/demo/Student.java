package demo;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private String name;
    private String id;
    private String department;


    public Student(String name, String id, String department){
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id) && Objects.equals(department, student.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, department);
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
