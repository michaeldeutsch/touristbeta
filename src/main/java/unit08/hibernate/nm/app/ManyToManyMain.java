package at.fhvie.hibernate.nm.app;

import at.fhvie.hibernate.config.HibernateUtil;
import at.fhvie.hibernate.nm.dao.AmenityDao;
import at.fhvie.hibernate.nm.dao.HotelDao;
import at.fhvie.hibernate.nm.entities.Amenity;
import at.fhvie.hibernate.nm.entities.Hotel;
import org.hibernate.SessionFactory;

public class ManyToManyMain {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(Hotel.class, Amenity.class)) {
            HotelDao hotelDao = new HotelDao(sessionFactory);
            AmenityDao amenityDao = new AmenityDao(sessionFactory);

            Hotel hotelSacher = new Hotel("Hotel Sacher", "Wien");
            Hotel hotelDonau = new Hotel("Hotel Donau", "Wien");

            Amenity spa = new Amenity("Spa");
            Amenity parking = new Amenity("Parkplatz");
            Amenity wifi = new Amenity("WLAN");

            hotelSacher.addAmenity(spa);
            hotelSacher.addAmenity(wifi);

            Long sacherId = hotelDao.save(hotelSacher); // CascadeType.PERSIST speichert Spa und WLAN mit.
            Long donauId = hotelDao.save(hotelDonau);
            Long parkingId = amenityDao.save(parking);

            // Showcase: Bestehendes Hotel bekommt bestehende Amenity.
            hotelDao.addExistingAmenityToExistingHotel(donauId, parkingId);

            // Showcase: Bestehendes Hotel bekommt weitere bestehende Amenity.
            Amenity existingWifi = hotelDao.findById(sacherId).getAmenities().stream()
                    .filter(a -> a.getName().equals("WLAN"))
                    .findFirst()
                    .orElseThrow();
            hotelDao.addExistingAmenityToExistingHotel(donauId, existingWifi.getId());

            System.out.println("\n--- n:m Hotels mit Amenities ---");
            hotelDao.findAll().forEach(System.out::println);
        }
    }
}
