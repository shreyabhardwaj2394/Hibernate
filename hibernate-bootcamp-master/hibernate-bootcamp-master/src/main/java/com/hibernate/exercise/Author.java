package com.hibernate.exercise;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shreya on 7/4/2017.
 */
@Entity
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Author_ID")
    int id;
    @Column(name="F_Name")
    String FirstName;
    @Transient
    @Column(name="L_Name")
    String LastName;
    @Column(name="Author_Age")
    int age;
    @Temporal(TemporalType.DATE)@Column(name="Dob") //use @Temporal
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                '}';
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
