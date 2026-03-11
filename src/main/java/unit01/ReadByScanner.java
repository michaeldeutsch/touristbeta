package unit01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadByScanner {

    static void main() throws FileNotFoundException {

        String path = "src/main/resources/name.txt";

        File file = new File(path);

        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }


    }

}
