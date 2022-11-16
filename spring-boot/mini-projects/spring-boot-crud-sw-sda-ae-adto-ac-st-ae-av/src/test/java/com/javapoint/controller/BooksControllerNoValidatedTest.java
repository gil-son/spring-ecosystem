package com.javapoint.controller;


import com.javapoint.entity.Books;
import com.javapoint.service.BooksServiceNoValidated;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BooksControllerNoValidatedTest {

    @MockBean
    private BooksServiceNoValidated service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetAllBooksList() throws Exception{
        // <ACTION> should <EFFECT> [when <SCENERY>]

        // Arrange: instance of common objects
        when(service.getAllBooks()).thenReturn(getAllBooks());

        // Act: run as needed
        mockMvc.perform(MockMvcRequestBuilders
                .get("/book"))

        // Assert: declare what Should happen (expected result)
                .andExpect(MockMvcResultMatchers.status().isOk())

        // to improve
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$[0].bookname", Matchers.is("Book-1")))
                .andExpect(jsonPath("$[1].bookname", Matchers.is("Book-2")))
                .andExpect(jsonPath("$[2].bookname", Matchers.is("Book-3")));
    }

    private List<Books> getAllBooks(){
        List<Books> booksList = new ArrayList<>();
        booksList.add(new Books(1, "Book-1", "Author-1", 100));
        booksList.add(new Books(2, "Book-2", "Author-2", 200));
        booksList.add(new Books(3, "Book-3", "Author-3", 300));
        return booksList;
    }




}
