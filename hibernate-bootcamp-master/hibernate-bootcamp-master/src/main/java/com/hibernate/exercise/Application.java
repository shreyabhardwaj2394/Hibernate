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
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("Done");


    }
}
