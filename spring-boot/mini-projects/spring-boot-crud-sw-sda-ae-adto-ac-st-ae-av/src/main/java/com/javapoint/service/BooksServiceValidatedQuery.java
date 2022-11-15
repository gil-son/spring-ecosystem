package com.javapoint.service;

import com.javapoint.entity.Books;
import com.javapoint.repository.BooksRepository;
import com.javapoint.repository.BooksRepositoryQuery;
import com.javapoint.service.exception.MyBusinessException;
import com.javapoint.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceValidatedQuery {

    @Autowired
    BooksRepositoryQuery booksRepositoryQuery;

    public Integer maxPrice(){
        return booksRepositoryQuery.findMaxValueBook().orElseThrow();
    }

    public List<Books> findByInitial(String initialname){
        System.out.println("LOOOOG");
        System.out.println(booksRepositoryQuery.findByInitial(initialname).get());
        return booksRepositoryQuery.findByInitial(initialname).orElseThrow();
    }


    public List<Books> findByQueryAll(){
        System.out.println("LOOOOG");
        System.out.println(booksRepositoryQuery.findByQueryAll().get());
        return booksRepositoryQuery.findByQueryAll().orElseThrow();
    }

}
