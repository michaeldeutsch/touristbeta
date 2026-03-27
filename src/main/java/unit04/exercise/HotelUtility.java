package unit04.exercise;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelUtility {

    static ArrayList<Hotel> hotels = new ArrayList<>();

    static{
        hotels.add(new Hotel(1,"H1",1010  ));
        hotels.add(new Hotel(2,"H2",1010  ));
        hotels.add(new Hotel(3,"H3",1010  ));
    }

    public static ArrayList<Hotel> getHotels(){
        return hotels;
    }

    public static void writeHotelsAsSQL(boolean append) throws IOException {
        LocalDate date = LocalDate.now();
        Path path = Path.of("output/backup" + date + ".sql");       // structure / place



        ArrayList<String> hotelsAsSqlStatements = new ArrayList<>();

        for(Hotel h : hotels){
            hotelsAsSqlStatements.add(h.toSQL());
        }

        Files.write(path,  // Path
                hotelsAsSqlStatements,  // data
                StandardCharsets.UTF_8,
                append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE
        );
        System.out.println("File was written sucessfully");
    }

}
