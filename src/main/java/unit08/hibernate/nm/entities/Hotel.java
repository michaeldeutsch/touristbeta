package unit08.hibernate.nm.entities;

import lombok.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "nm_Hotel")
@Table(name = "nm_hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "amenities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "hotel_name", nullable = false, length = 120)
    private String name;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    // n:m Beziehung: Ein Hotel hat viele Amenities, eine Amenity kann zu vielen Hotels gehören.
    // CascadeType.PERSIST/MERGE speichert neue Amenities mit, löscht bestehende Amenities aber nicht automatisch.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "nm_hotel_amenities",
            joinColumns = @JoinColumn(name = "hotel_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "amenity_id", nullable = false)
    )
    private Set<Amenity> amenities = new HashSet<>();

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
        amenity.getHotels().add(this);
    }

    public void removeAmenity(Amenity amenity) {
        amenities.remove(amenity);
        amenity.getHotels().remove(this);
    }
}
