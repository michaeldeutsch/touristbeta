package unit06;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Hotel {

    private int id;
    private String name;
    private String adresse;
    private String category;
}
