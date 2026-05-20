package unit08.hibernate.nm.dao;

import unit08.hibernate.nm.entities.Amenity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class AmenityDao {

    private final SessionFactory sessionFactory;

    public AmenityDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Amenity amenity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(amenity);
            session.getTransaction().commit();
            return amenity.getId();
        }
    }

    public Amenity findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Amenity.class, id);
        }
    }

    public List<Amenity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Amenity", Amenity.class).list();
        }
    }
}
