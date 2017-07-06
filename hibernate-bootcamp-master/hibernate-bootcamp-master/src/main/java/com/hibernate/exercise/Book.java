package com.hibernate.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Shreya on 7/6/2017.
 */
@Entity
public class Book {
    @Id
    String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
