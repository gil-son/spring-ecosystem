package com.javapoint.service;

import com.javapoint.entity.Books;
import com.javapoint.repository.BooksRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class BookServiceTest {


    @InjectMocks // Inject the created instances from mocks
    private BooksServiceNoValidated booksService;

    @MockBean // Execute mock from
    private BooksRepository booksRepository;

    //@Mock // Instance object with mocks
    Books books = Mockito.mock(Books.class);


    @Test
    public void shouldCreateABook(){

        Mockito.when(booksRepository.save(books)).thenReturn(books);
        Assertions.assertEquals(booksRepository.save(books), books);
    }

}
