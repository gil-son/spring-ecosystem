package com.javapoint.repository;

import com.javapoint.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BooksRepositoryQuery extends JpaRepository<Books, Integer>
{

     //@Query("SELECT u FROM User u WHERE u.status = 1")
     @Query("SELECT MAX(b.price) FROM Books b")
     Optional<Integer> findMaxValueBook();

     // SELECT * FROM TB_BOOK bookname WHERE bookname like 'A%'
     @Query("SELECT b FROM Books b WHERE b.bookname = :name")
     Optional<List<Books>> findByInitial(@Param("name") String initialname);

     @Query("SELECT b FROM Books b")
     Optional<List<Books>> findByQueryAll();

//     @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//     User findUserByStatusAndName(Integer status, String name);
}