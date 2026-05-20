package at.fhvie.hibernate.onetomany.dao;

import at.fhvie.hibernate.onetomany.entities.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class BookingDao {

    private final SessionFactory sessionFactory;

    public BookingDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Booking findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Booking.class, id);
        }
    }

    public List<Booking> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Booking", Booking.class).list();
        }
    }
}
