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
    /*@Temporal(TemporalType.DATE)@Column(name="Dob") //use @Temporal
    Date date;*/

/*    @Embedded
    Address address;*/

    //List of subjects
    @OneToMany
    @JoinTable(joinColumns=@JoinColumn(name="Author_Id")
    ,inverseJoinColumns=@JoinColumn(name="Subject_Id"))
    List<Subjects> subjects=new ArrayList<>();

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    /* public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

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

