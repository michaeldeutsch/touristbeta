package unit04.structure;

import java.util.ArrayList;
import java.util.Collections;

public class SortingOfPrimitives {

    static void main() {


        ArrayList<Integer> numbers = new ArrayList<Integer>();

        Collections.sort(numbers);

        numbers.add(1);
        numbers.add(2);
        numbers.add(34);
        numbers.add(4);
        numbers.add(5);
        numbers.forEach(System.out::println);

    }
}
