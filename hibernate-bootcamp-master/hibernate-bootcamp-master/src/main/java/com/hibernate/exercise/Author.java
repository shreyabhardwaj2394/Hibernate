package com.hibernate.exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Shreya on 7/4/2017.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "Author_ID")
    int id;
    @Column(name="F_Name")
    String FirstName;
    @Transient
    @Column(name="L_Name")
    String LastName;
    @Column(name="Author_Age")
    int age;

    @OneToOne
    @JoinColumn(name="BookJoin")
    Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

