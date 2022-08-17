package com.javapoint;

import com.javapoint.entity.Books;
import com.javapoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Command implements ApplicationRunner {

    @Autowired
    BooksService booksService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        Books book1 = new Books(1111, "A-book", "A-Author",100);
        Books book2 = new Books(2222, "B-book", "B-Author",200);
        Books book3 = new Books(3333, "C-book", "C-Author",300);

        booksService.saveOrUpdate(book1);
        booksService.saveOrUpdate(book2);
        booksService.saveOrUpdate(book3);
    }
}