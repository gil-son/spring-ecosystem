package com.javapoint.controller;


import com.javapoint.entity.Books;
import com.javapoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//mark class as Controller
@RestController
public class BooksController
{
    //autowire the BooksService class
    @Autowired
    BooksService booksService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid)
    {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/book")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/book")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }
}
