package com.one_to_one_join_table_in_jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
	
    @Column(name = "book_name")
    private String bookName;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @JsonManagedReference
    private Story story;
    
    public Story getStory() {
        return story;
    }
    public void setStory(Story story) {
        this.story = story;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
