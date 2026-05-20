package unit08.hibernate.nm.entities;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "nm_amenities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "amenity_name", nullable = false, unique = true, length = 80)
    private String name;

    // mappedBy zeigt: Die Join-Tabelle wird auf Hotel-Seite definiert.
    @ManyToMany(mappedBy = "amenities")
    @ToString.Exclude
    private Set<Hotel> hotels = new HashSet<>();

    public Amenity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
