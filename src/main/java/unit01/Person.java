package unit01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

    @NonNull
    int id;
    @NonNull
    String name;
    @NonNull
    String email;
    String password;
    String phone;
    String address;
    String city;
    String country;
    String zip;
    String asdasfd;


}
