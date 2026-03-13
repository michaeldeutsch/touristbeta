package unit02.readFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void main() throws FileNotFoundException {

        ArrayList<Hotel> hotels = getHotels();

        hotels.forEach(System.out::println); // package to deliver



    }

    private static ArrayList<Hotel> getHotels() throws FileNotFoundException {
        String path  = "src/main/resources/hotels.csv";

        Scanner sc = new Scanner(new File(path));
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        while(sc.hasNextLine()){

          String parts [] =   sc.nextLine().split(",");
         // System.out.println(Arrays.toString(parts));
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int post_code = Integer.parseInt(parts[2]);

            Hotel temp = new Hotel(id,name,post_code);
            hotels.add(temp);


        }
        return hotels;
    }
}
