package unit08.hibernate.onetomany.entities;

import lombok.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "om_Hotel")
@Table(name = "om_hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "bookings")
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

    // 1:n Beziehung: Ein Hotel hat viele Buchungen.
    // CascadeType.ALL speichert, aktualisiert und löscht Buchungen mit dem Hotel.
    // orphanRemoval=true löscht Buchungen, wenn sie aus der Liste entfernt werden.
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setHotel(this);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setHotel(null);
    }
}
