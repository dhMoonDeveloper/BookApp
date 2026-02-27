package com.bookapp.backend.book.dto.request;

public record UpdateBookRequest (
    String title,
    String subTitle,
    String author,
    String content,
    String coverImageUrl
) {}
