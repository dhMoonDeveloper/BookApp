package com.bookapp.backend.book.service;

import com.bookapp.backend.book.dto.request.CreateBookRequest;
import com.bookapp.backend.book.dto.request.UpdateBookRequest;
import com.bookapp.backend.book.dto.response.BookResponse;
import com.bookapp.backend.book.exception.BookNotFoundException;
import com.bookapp.backend.book.repository.BookRepository;
import com.bookapp.backend.book.vo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책 목록 조회
    public List<BookResponse> getBooks() {
        return bookRepository.findAll().stream().map(BookResponse::from).toList();
    }

    // 책 조회 (단건)
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    // 책 등록
    public Book createBook(CreateBookRequest req) {
        Book book = new Book(
                req.title(),
                req.author(),
                req.content(),
                req.coverImageUrl()
        );
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, UpdateBookRequest req) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.update(req.title(), req.content(), req.author(), req.coverImageUrl());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.deleteById(id);
    }

}
