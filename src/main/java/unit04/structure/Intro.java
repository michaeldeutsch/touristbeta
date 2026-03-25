package unit04.structure;

import java.util.ArrayList;
import java.util.Collections;

public class Intro {

    static void main() {

        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'c');



        ArrayList<String> words = new ArrayList<>();
        words.add("Zebra");
        words.add("Aippo");
        words.add("Ant");
        words.add("Lion");

        words.forEach(System.out::println);

        Collections.sort(words);

        System.out.println("*".repeat(20));
        words.forEach(System.out::println);

        String[] words2 = {"Hello","World"};


    }
}
