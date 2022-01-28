package com.one_to_one_join_table_in_jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "story")
public class Story {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int storyId;
    
    @Column(name = "story_name")
    
    private String storyName;
    
    @OneToOne(cascade = CascadeType.ALL)
    
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;
    
    public int getStoryId() {
        return storyId;
    }
    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
    public String getStoryName() {
        return storyName;
    }
    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}