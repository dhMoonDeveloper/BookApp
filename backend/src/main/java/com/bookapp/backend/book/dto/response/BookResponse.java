package com.bookapp.backend.book.dto.response;

import com.bookapp.backend.book.vo.Book;

import java.time.LocalDateTime;

public record BookResponse(
    Long id,
    String title,
    String author,
    String content,
    String coverImageUrl,
    LocalDateTime createdAt
){
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getContent(),
                book.getCoverImageUrl(),
                book.getCreatedAt()
        );
    }
}

