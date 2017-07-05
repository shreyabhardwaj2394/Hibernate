package com.hibernate.exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Created by Shreya on 7/4/2017.
 */
public class Application {
    public static void main(String[] args) {

        //CREATE
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Author author1=new Author();
//        author1.setId(1);
        author1.setFirstName("shreya");
        author1.setLastName("bhardwaj");
        author1.setAge(22);
        session.save(author1);

        Author author2=new Author();
//        author2.setId(2);
        author2.setAge(15);
        author2.setFirstName("vishesh");
        author2.setLastName("bhardwaj");
        session.save(author2);

        Author author3=new Author();
//        author3.setId(3);
        author3.setFirstName("Will be");
        author3.setLastName("Deleted");
        author3.setAge(14);
        session.save(author3);

        //Read
        Author readAuthor=session.get(Author.class,1);
        System.out.println(readAuthor.toString());
        try {
            //Update
            Author updateAuthor = session.get(Author.class, 2);
            updateAuthor.setFirstName("Updated First Name");
            session.update(updateAuthor);

            //Delete
            Author deleteAuthor = session.get(Author.class, 3);
            session.delete(deleteAuthor);
        } catch (RuntimeException e) {
            System.out.println("-------------------------------");
        }


        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("Done");


    }
}
