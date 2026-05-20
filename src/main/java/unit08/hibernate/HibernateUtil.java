package unit07.persistence.user;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import unit07.persistence.person.PersonEntity;

public class HibernateUtil {

    static {
        System.setProperty("org.jboss.logging.provider", "slf4j");
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");
        System.setProperty("org.slf4j.simpleLogger.log.org.hibernate", "off");
        System.setProperty("org.slf4j.simpleLogger.log.org.jboss", "off");
    }

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure()
                    .addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(PersonEntity.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory couldn't be created.");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}