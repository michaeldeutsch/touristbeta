package unit08.hibernate.nm.dao;

import unit08.hibernate.nm.entities.Amenity;
import unit08.hibernate.nm.entities.Hotel;
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
                    "select h from nm_Hotel h left join fetch h.amenities where h.id = :id",
                    Hotel.class
            ).setParameter("id", id).uniqueResult();
        }
    }

    public void addExistingAmenityToExistingHotel(Long hotelId, Long amenityId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Hotel hotel = session.find(Hotel.class, hotelId);
            Amenity amenity = session.find(Amenity.class, amenityId);

            if (hotel == null || amenity == null) {
                throw new IllegalArgumentException("Hotel oder Amenity existiert nicht.");
            }

            hotel.addAmenity(amenity);

            session.getTransaction().commit();
        }
    }

    public List<Hotel> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "select distinct h from nm_Hotel h left join fetch h.amenities",
                    Hotel.class
            ).list();
        }
    }
}
