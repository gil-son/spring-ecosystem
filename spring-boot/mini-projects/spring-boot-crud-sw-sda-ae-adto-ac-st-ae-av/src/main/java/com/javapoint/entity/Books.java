package com.javapoint.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "tb_book")
public class Books
{
    //Defining book id as primary key
    @Id
    @Column
    private int bookid;
    @Column
    private String bookname;
    @Column
    private String author;
    @Column
    private int price;

    public Books()
    {

    }
    public Books(int bookid, String bookname, String author, int price)
    {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public int getBookid()
    {
        return bookid;
    }

    public void setBookid(int bookid)
    {
        this.bookid = bookid;
    }

    public String getBookname()
    {
        return bookname;
    }

    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

}
