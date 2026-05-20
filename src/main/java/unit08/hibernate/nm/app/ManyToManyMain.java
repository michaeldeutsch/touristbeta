package unit08.hibernate.nm.app;

import unit08.hibernate.HibernateUtil;
import unit08.hibernate.nm.dao.AmenityDao;
import unit08.hibernate.nm.dao.HotelDao;
import unit08.hibernate.nm.entities.Amenity;
import unit08.hibernate.nm.entities.Hotel;
import org.hibernate.SessionFactory;

public class ManyToManyMain {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
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
