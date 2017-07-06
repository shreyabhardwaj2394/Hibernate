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
        try{
            Transaction transaction = session.beginTransaction();

            Author author1=new Author();
            author1.setFirstName("shreya");
            author1.setLastName("bhardwaj");
            author1.setAge(22);
           //For one to one mapping
            Book book=new Book();
            book.setBookName("First Book");
            author1.setBook(book);
            session.save(book);
            session.save(author1);

            transaction.commit();

        }catch (RuntimeException e){
            System.out.println("------");
        }
        finally {
            session.close();
            sessionFactory.close();
        }


        System.out.println("Done");

    }
}
