package com.javapoint.controller;

import com.javapoint.entity.Books;
import com.javapoint.service.BooksServiceValidated;
import com.javapoint.service.BooksServiceValidatedQuery;
import com.javapoint.service.exception.MyBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksControllerValidatedQuery {

    @Autowired
    BooksServiceValidatedQuery booksServiceValidatedQuery;

    @PostMapping("/q-max-book")
    private ResponseEntity<Integer> maxBookPrice() {
        Integer value = booksServiceValidatedQuery.maxPrice();
        return ResponseEntity.ok(value);
    }

    @PostMapping("/q-initial-name-book")
    private ResponseEntity<List<Books>> findByInitial(@RequestBody String initialname) {
        List<Books> value = booksServiceValidatedQuery.findByInitial(initialname);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/q-find-all-book")
    private ResponseEntity<List<Books>> findByQueryAll() {
        List<Books> value = booksServiceValidatedQuery.findByQueryAll();
        return ResponseEntity.ok(value);
    }

}
