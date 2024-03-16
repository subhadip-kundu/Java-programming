package Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating Question1
        Question q1 = new Question();
        q1.setQuestionId(01);
        q1.setQuestion("What is java?");

        //Creating Answer
        Answer a1 = new Answer();
        a1.setAnswerId(99);
        a1.setAnswer("Java is programming language");
        a1.setQuestion(q1);
        q1.setAnswer(a1);


        //Creating Question2
        Question q2 = new Question();
        q2.setQuestionId(02);
        q2.setQuestion("What is Collection framework ?");

        //Creating Answer
        Answer a2 = new Answer();
        a2.setAnswerId(98);
        a2.setAnswer("API to work with objects in java");
        a2.setQuestion(q2);
        q2.setAnswer(a2);

        //Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.persist(q1);
        s.persist(q2);

        tx.commit();
        s.close();
        factory.close();
    }
}
