package unit04.structure.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortingOfObjects {

    static void main() {

        Student s = new Student("Hans", 111, 1.5);
        Student s1 = new Student("Gretel", 111, 3.5);
        Student s2 = new Student("Franz", 32, 5.5);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s);
        students.add(s1);
        students.add(s2);

        Collections.sort(students);
        students.forEach(System.out::println);

    }
}
