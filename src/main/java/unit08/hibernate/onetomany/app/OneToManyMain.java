package unit08.hibernate.onetomany.app;

import unit08.hibernate.HibernateUtil;
import unit08.hibernate.onetomany.dao.BookingDao;
import unit08.hibernate.onetomany.dao.HotelDao;
import unit08.hibernate.onetomany.entities.Booking;
import unit08.hibernate.onetomany.entities.Hotel;
import org.hibernate.SessionFactory;
import java.time.LocalDate;

public class OneToManyMain {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            HotelDao hotelDao = new HotelDao(sessionFactory);
            BookingDao bookingDao = new BookingDao(sessionFactory);

            Hotel hotelSacher = new Hotel("Hotel Sacher", "Wien");
            hotelSacher.addBooking(new Booking("Anna Berger", LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 5), 2));

            Long sacherId = hotelDao.save(hotelSacher); // CascadeType.ALL speichert die erste Buchung mit.

            Hotel hotelDonau = new Hotel("Hotel Donau", "Wien");
            Long donauId = hotelDao.save(hotelDonau);

            // Showcase: Bestehendes Hotel bekommt neue Buchungen.
            hotelDao.addBookingToExistingHotel(
                    sacherId,
                    new Booking("Max Huber", LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 14), 1)
            );

            hotelDao.addBookingToExistingHotel(
                    donauId,
                    new Booking("Lisa Steiner", LocalDate.of(2026, 8, 3), LocalDate.of(2026, 8, 8), 3)
            );

            System.out.println("\n--- 1:n Hotels mit Buchungen ---");
            hotelDao.findAll().forEach(System.out::println);

            System.out.println("\n--- Alle Buchungen ---");
            bookingDao.findAll().forEach(System.out::println);
        }
    }
}
