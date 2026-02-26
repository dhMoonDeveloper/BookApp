package com.bookapp.backend.book.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book Not Found Id = " + id);
    }
}
