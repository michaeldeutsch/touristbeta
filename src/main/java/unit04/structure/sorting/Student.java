package unit04.structure.sorting;

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
