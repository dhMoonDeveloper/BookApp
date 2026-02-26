package com.bookapp.backend.book.repository;

import com.bookapp.backend.book.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
