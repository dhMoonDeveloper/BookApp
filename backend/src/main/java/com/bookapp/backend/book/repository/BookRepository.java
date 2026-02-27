package com.bookapp.backend.book.repository;

import com.bookapp.backend.book.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM books ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Book> findRandomBooks(int limit);

    @Query(value = """
    SELECT * FROM books
     WHERE LOWER(title) LIKE LOWER(CONCAT('%', :q, '%'))
        OR LOWER(author) LIKE LOWER(CONCAT('%', :q, '%'))""", nativeQuery = true)
    List<Book> searchBook(@Param("q") String q);
}
