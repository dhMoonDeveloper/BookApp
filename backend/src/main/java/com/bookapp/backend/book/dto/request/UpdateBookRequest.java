package com.bookapp.backend.book.dto.request;

public record UpdateBookRequest (
    String title,
    String author,
    String content,
    String coverImageUrl
) {}
