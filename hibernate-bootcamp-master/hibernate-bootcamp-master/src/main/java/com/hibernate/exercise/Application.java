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

            Address address=new Address();
            address.setStreetNumber(12);
            address.setLocation("CP");
            address.setState("Delhi");


            Author author=new Author();
            author.setFirstName("abc");
            author.setLastName("def");
            author.setAge(31);
            author.setDate(new GregorianCalendar(1994,12,23).getTime());
            author.setAddress(address);
            session.save(author);

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
