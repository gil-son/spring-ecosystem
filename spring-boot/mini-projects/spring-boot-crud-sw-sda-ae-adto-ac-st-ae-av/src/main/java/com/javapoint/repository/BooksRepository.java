package com.javapoint.repository;

import com.javapoint.entity.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BooksRepository extends CrudRepository<Books, Integer>
{

     Optional<String> findByBookname(String name);

}