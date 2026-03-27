package unit04.exercise;

import java.io.IOException;

public class MyApplication {


    static void main() throws IOException {


            HotelUtility.writeHotelsAsSQL(false);


            HotelUtility.writeHotelsAsSQL(true);

    }
}
