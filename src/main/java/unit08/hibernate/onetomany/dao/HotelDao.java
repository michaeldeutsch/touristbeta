package at.fhvie.hibernate.onetomany.dao;

import at.fhvie.hibernate.onetomany.entities.Booking;
import at.fhvie.hibernate.onetomany.entities.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class HotelDao {

    private final SessionFactory sessionFactory;

    public HotelDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Hotel hotel) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(hotel);
            session.getTransaction().commit();
            return hotel.getId();
        }
    }

    public Hotel findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "select h from Hotel h left join fetch h.bookings where h.id = :id",
                    Hotel.class
            ).setParameter("id", id).uniqueResult();
        }
    }

    public void addBookingToExistingHotel(Long hotelId, Booking booking) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Hotel hotel = session.find(Hotel.class, hotelId);
            if (hotel == null) {
                throw new IllegalArgumentException("Hotel existiert nicht.");
            }

            hotel.addBooking(booking);
            // Wegen CascadeType.ALL auf Hotel.bookings wird die neue Buchung automatisch gespeichert.

            session.getTransaction().commit();
        }
    }

    public List<Hotel> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "select distinct h from Hotel h left join fetch h.bookings",
                    Hotel.class
            ).list();
        }
    }
}
