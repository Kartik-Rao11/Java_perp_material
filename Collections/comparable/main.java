package Collections.comparable;

import java.util.*;

/**
 * 
 * Comparable interface -> It helps to define natural ordering of Objects. It
 * has only method compareTo.
 * 
 * compareTo() -> This method compares this object with the specified object.
 */

class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student obj) {
        return Integer.compare(this.age, obj.age);

    }

}

class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("kartik", 19));
        students.add(new Student("Rahul", 21));
        students.add(new Student("Mishra", 23));

        Collections.sort(students);
        System.out.println(students);
    }
}