package unit02.lombok.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    int matrikelNr;
    String name;
}
