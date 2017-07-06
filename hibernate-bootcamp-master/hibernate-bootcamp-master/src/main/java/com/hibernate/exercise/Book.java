package com.hibernate.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shreya on 7/6/2017.
 */

//create a book entity
@Entity
public class Book {
    @Id
    String bookName;

    @ManyToMany(mappedBy = "book")
    Collection<Author> author=new ArrayList<>();

    public Collection<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Collection<Author> author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
