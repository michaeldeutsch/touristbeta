package unit04.structure;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {


    String name;
    int age;
    double gpa;


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

    @Override
    public int compareTo(Student o) {

        if(o.age == this.age){
           if(o.gpa > this.gpa) {
               return 1;
           }else{
               return - 1;
           }
        }else{
            return o.age - this.age;
        }

    }
}
