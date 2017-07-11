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
            Author author=new Author();
            author.setFirstName("abc");
            author.setLastName("def");
            author.setAge(31);
            author.setDate(new GregorianCalendar(1994,12,23).getTime());
            session.save(author);

            Author author2=new Author();
            author2.setFirstName("rahul");
            author2.setLastName("gagan");
            author2.setAge(25);
            author2.setDate(new GregorianCalendar(1991,10,23).getTime());
            session.save(author2);

            Author author3=new Author();
            author3.setFirstName("rahul");
            author3.setLastName("gagan");
            author3.setAge(25);
            author3.setDate(new GregorianCalendar(1991,10,23).getTime());
            session.save(author3);

            transaction.commit();
        }catch (RuntimeException e){
            System.out.println("------");
        }
        session.close();
        sessionFactory.close();

        System.out.println("Done");

    }
}
