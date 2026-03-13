package unit02.lombok.lecturer;

public class Main {

    static void main() {

        Lecturer l = Lecturer.builder().name("Lecturer").build();
        Lecturer l2 = Lecturer.builder().name("John").id(1).build();
        Lecturer l3 = Lecturer.builder().id(2).email("adf").build();
        Lecturer l4 = Lecturer.builder().name("adsf").email("adf").build();
        System.out.println(l);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);


    }
}
