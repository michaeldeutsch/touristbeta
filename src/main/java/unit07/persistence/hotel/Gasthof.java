package unit07.persistence.hotel;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Gasthof {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gasthofID;
    @NonNull
    @Column(unique = true)
    private String gasthofName;

}
