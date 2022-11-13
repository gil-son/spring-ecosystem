package com.javapoint.controller;

import com.javapoint.entity.Books;
import com.javapoint.service.BooksServiceValidated;
import com.javapoint.service.exception.MyBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NameAlreadyBoundException;

@RestController
public class BooksControllerValidated {

    @Autowired
    BooksServiceValidated booksService;

    @PostMapping("/v-book")
    private ResponseEntity<Books> saveAndValidateABook(@RequestBody Books books) throws MyBusinessException {
        Books abook = booksService.saveBook(books);
        return ResponseEntity.ok(abook);
    }

}
