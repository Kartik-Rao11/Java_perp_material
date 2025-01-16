package Collections.comparator;

import java.util.*;

/**
 * Comparator -> It is an interface that defines custom ordering of the objects.
 * It has two methods compare() and equals().
 * 
 * compare() -> Helps to compare two objects.
 * If obj1 < obj2 return -1
 * if obj1 == obj2 return 0
 * if obj1 > obj2 return 1
 * 
 * equals() -> Helps to check equality of two objects
 */

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student obj1, Student obj2) {
        return obj1.name.compareTo(obj2.name);
    }

}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student obj1, Student obj2) {
        return Integer.compare(obj1.age, obj2.age);
    }

}

class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kartik", 23));
        students.add(new Student("Rao", 34));
        students.add(new Student("john", 45));
        // Using comparator we can have custom ordering of List
        Collections.sort(students, new AgeComparator()); // sorting the list on the basis of the age
        System.out.println(students);
        Collections.sort(students, new NameComparator()); // sorting the list on the basis of the name
        System.out.println(students);
    }
}
