package unit02.lombok.student;

public class MainStudent {


    static void main(String[] args) {
        Student s = new Student(1, "Michael");
        System.out.println(s.getName());
        System.out.println(s);
    }
}
