import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student aman = new Student("aman", "aman@gmail.com");
        Student chetan = new Student("chetan", "chetan@gmail.com");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(aman);
        session.persist(chetan);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Saved: " + aman);
        System.out.println("Saved: " + chetan);
    }
}