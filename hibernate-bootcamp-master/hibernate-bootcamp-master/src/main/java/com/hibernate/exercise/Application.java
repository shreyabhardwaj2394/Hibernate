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

            Subjects subject1=new Subjects();
            subject1.setSubjectName("Science");

            Subjects subject2=new Subjects();
            subject2.setSubjectName("English");

            Subjects subject3=new Subjects();
            subject3.setSubjectName("Maths");

            Subjects subject4=new Subjects();
            subject4.setSubjectName("CS");


            Author author1=new Author();
            author1.setFirstName("shreya");
            author1.setLastName("bhardwaj");
            author1.setAge(22);
           //Adding multiple subjects
            author1.getSubjects().add(subject1);
            author1.getSubjects().add(subject2);
            author1.getSubjects().add(subject3);
            session.save(author1);
            session.save(subject1);
            session.save(subject2);
            session.save(subject3);
            session.save(subject4);
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
