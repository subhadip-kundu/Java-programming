package hibernateOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();

            //Using get method
            Student student = (Student) session.get(Student.class, 103);
            System.out.println(student.getName());

            //Using set method
            try {
                session.load(Student.class, 103);
            } catch (Exception e) {
                System.out.println("Can't load this id : " + e.getMessage());
            }
            System.out.println(student.getName());

            session.close();
            factory.close();
        } catch (Exception e) {
            System.out.println("Some error occur during fetch " + e.getMessage());
        }
    }
}
