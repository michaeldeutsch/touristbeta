package unit04.structure;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {

        TreeSet<Student> set = new TreeSet<Student>();
        set.add(new Student("Hans", 111, 1.5));
        set.add(new Student("Hans", 111, 1.5));
        set.add(new Student("Franz", 32, 5.5));
        set.add(new Student("Franz", 66, 5.5));

        set.forEach(student -> System.out.println(student));

    }
}
