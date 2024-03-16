package hibernateOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {

    private static Address createAddress() throws IOException {
        Address ad = new Address();
        ad.setStreet("Street 1");
        ad.setOpen(true);
        ad.setCity("Bankura");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setEntryFee(100);

        // Reading Image
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\000.png")) {
            byte[] data = new byte[file.available()];
            file.read(data);
            ad.setImage(data);
        }
        return ad;
    }

    public static void main(String[] args) {
        System.out.println("Project Started ....");

        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            try (SessionFactory factory = cfg.buildSessionFactory();
                 Session session = factory.openSession()) {

                // Creating Student
                Student st = new Student();
                st.setId(102);
                st.setName("Ayan roy");
                st.setCity("Bankura");
                System.out.println(st);

                // Creating Student
                Address ad = createAddress();

                Transaction tx = session.beginTransaction();
                session.persist(st);
                session.persist(ad);
                tx.commit();

                session.close();
                System.out.println("Done...");
            }
        } catch (Exception e) {
            // Use a logging framework instead of printing to console
            System.err.println("Error occurred while initializing SessionFactory: " + e.getMessage());
        }
    }
}
