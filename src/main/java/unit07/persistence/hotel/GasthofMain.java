package unit07.persistence.hotel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import unit07.persistence.user.UserEntity;

import java.util.List;

public class GasthofMain {

    private static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();


    public static void main(String[] args) {

        /*
        Gasthof g = Gasthof.builder().gasthofName("Reinthaler").build();
        System.out.println(g);
        System.out.println(g1);

        Gasthof temp = createGasthof(g);
        System.out.println(temp);

        deleteGasthof(1);

        Gasthof g1 = new Gasthof("Stüberl");
        createGasthof(g1);
*/
        findByName("Stüberl");
    }

    /**
     * authors: michael.deutsch
     * @param term
     */
    private static void findByName(String term ) {
        Transaction tx = null;

        try(Session session = SESSION_FACTORY.openSession()){
            tx = session.beginTransaction();

            String hql = "from Gasthof where gasthofName = :term";

          Gasthof g=   session.createQuery(hql, Gasthof.class).setParameter("term", term).uniqueResult();
            System.out.println("Was found " + g);
            tx.commit();
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void deleteGasthof(int i) {

        Transaction tx = null;

        try(Session session = SESSION_FACTORY.openSession()){
            tx = session.beginTransaction();
            session.delete(session.get(Gasthof.class, i));
            tx.commit();
            System.out.println("Gasthof deleted");
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }


    }

    private static Gasthof createGasthof(Gasthof g) {

        Transaction tx = null;

        try(Session session = SESSION_FACTORY.openSession()) {
            tx = session.beginTransaction();
            session.persist(g);
            tx.commit();
            return g;
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;


    }


    private static void saveAll(List<Gasthof> gasthofs) {

        Transaction tx = null;
        int batchSize = 50;

        try(Session session = SESSION_FACTORY.openSession()) {
            tx = session.beginTransaction();

            for (int i = 0; i < gasthofs.size(); i++) {
                session.persist(gasthofs.get(i));
                if (i % batchSize == 0) {
                    session.flush();
                    session.clear();
                }
            }


            tx.commit();

        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }



    }
}
