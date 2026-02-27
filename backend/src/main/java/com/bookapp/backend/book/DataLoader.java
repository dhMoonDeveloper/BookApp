package com.bookapp.backend.book;

import com.bookapp.backend.book.repository.BookRepository;
import com.bookapp.backend.book.vo.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(String... args) {
        // bookRepository.save(new Book("첫 번째 책","첫번째 책 간략", "문동현.","간략 소개입니다.",null));
        // bookRepository.save(new Book("두 번째 책","첫번째 책 간략", "김다연.","간략 소개입니다.",null));
        // bookRepository.save(new Book("두 번째 글", "김다연.","간략 소개입니다2.",null));
    }
}
