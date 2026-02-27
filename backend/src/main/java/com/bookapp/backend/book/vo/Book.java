package com.bookapp.backend.book.vo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 책 번호 : PK

    @Column(nullable = false, length = 200)
    private String title; // 책 제목

    @Column(nullable = false, length = 300)
    private String subTitle;

    @Column(nullable = false, length = 100)
    private String author; // 책 저자

    @Column(length = 500)
    private String content; // 간략 소개

    @Column(length = 500)
    private String coverImageUrl;  // 이미지 URL

    @Column(nullable = false)
    private LocalDateTime createdAt;  // 등록 일자

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() { return subTitle; }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    protected Book() {}

    public Book(String title, String subTitle, String author, String content, String coverImageUrl) {
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.content = content;
        this.coverImageUrl = coverImageUrl;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String title, String subTitle, String content, String author, String coverImageUrl) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.author = author;
        this.coverImageUrl = coverImageUrl;
    }
}