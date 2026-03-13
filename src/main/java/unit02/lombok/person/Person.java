package unit02.lombok.person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    int  id;
    String name;
    String email;
    String  address;
    String  city;
    String  state;
    String  country;
    String  zip;
    String  phone;
    String  fax;
    String  description;
    String newElement;

}
