package unit02.lombok.lecturer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lecturer {

    int id; // m
    String name; // n
    String email; // optional

}
