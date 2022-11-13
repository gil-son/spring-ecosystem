package com.javapoint.service;

import com.javapoint.entity.Books;
import com.javapoint.repository.BooksRepository;
import com.javapoint.service.exception.MyBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameAlreadyBoundException;
import java.util.Optional;

@Service
public class BooksServiceValidated {

    @Autowired
    BooksRepository booksRepository;

    @Transactional
    public Books saveBook(Books books) throws MyBusinessException {

        Optional<String> name = booksRepository.findByBookname(books.getBookname());

        if(name.isPresent()){
            throw new MyBusinessException("Book already registered");
        }

        return booksRepository.save(books);

    }

}
