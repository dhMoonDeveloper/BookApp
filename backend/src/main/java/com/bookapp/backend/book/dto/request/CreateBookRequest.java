package com.bookapp.backend.book.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBookRequest (

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 200)
    String title,

    @NotBlank(message = "저자는 필수입니다.")
    @Size(max = 100)
    String author,

    @Size(max = 500)
    String content,

    String coverImageUrl

) {}
