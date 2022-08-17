package com.javapoint.repository;

import com.javapoint.entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer>
{
}