package hibernateOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class certiEmbidDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student std1 = new Student();
        std1.setId(01);
        std1.setName("Subhadip kundu");
        std1.setCity("Sonamukhi");


        Certificate certificate = new Certificate();
        certificate.setCourse("MERN");
        certificate.setDuration("12 Month");
        std1.setCerti(certificate);

        Student std2 = new Student();
        std2.setId(02);
        std2.setName("Shilpa kundu");
        std2.setCity("Bankura");


        Certificate certificate1 = new Certificate();
        certificate1.setCourse("MEAN");
        certificate1.setDuration("12 Month");
        std2.setCerti(certificate1);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        //Save
        s.persist(std1);
        s.persist(std2);

        tx.commit();
        s.close();
        factory.close();
    }
}