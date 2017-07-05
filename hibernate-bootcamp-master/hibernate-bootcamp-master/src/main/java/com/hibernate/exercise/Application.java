package com.hibernate.exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.GregorianCalendar;


/**
 * Created by Shreya on 7/4/2017.
 */
public class Application {
    public static void main(String[] args) {


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Author author1=new Author();
            author1.setFirstName("shreya");
            author1.setLastName("bhardwaj");
            author1.setAge(22);
            author1.setDate(new GregorianCalendar(1994,10,23).getTime());
            session.save(author1);


            Author author2=new Author();
            author2.setFirstName("rahul");
            author2.setLastName("gagan");
            author2.setAge(25);
            author2.setDate(new GregorianCalendar(1991,10,23).getTime());
            session.save(author2);

            Author author3=new Author();
            author3.setFirstName("skand");
            author3.setLastName("bhardwaj");
            author3.setAge(45);
            author3.setDate(new GregorianCalendar(1994,10,29).getTime());
            session.save(author3);

            Author author4=new Author();
            author4.setFirstName("abhimanyu");
            author4.setLastName("aggarwal");
            author4.setAge(24);
            author4.setDate(new GregorianCalendar(1992,11,29).getTime());
            session.save(author4);

            transaction.commit();
        }catch (RuntimeException e){
            System.out.println("----------------------------");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("Done");

    }
}
