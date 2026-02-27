package com.bookapp.backend.book.controller;

import com.bookapp.backend.book.dto.request.CreateBookRequest;
import com.bookapp.backend.book.dto.request.UpdateBookRequest;
import com.bookapp.backend.book.dto.response.BookResponse;
import com.bookapp.backend.book.service.BookService;
import com.bookapp.backend.book.vo.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getBoosks() {
        return bookService.getBooks();
    }

    @GetMapping("/random")
    public List<BookResponse> getRandomBooks(@RequestParam(defaultValue = "2") int limit) {

        limit = Math.max(1, Math.min(limit, 10));
        return bookService.getRandomBooks(limit);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/search")
    public List<BookResponse> getSearchBook(@RequestParam(required = false) String q) {
        return bookService.getSearchBook(q);
    }

    @PostMapping
    public Book createBook(@RequestBody CreateBookRequest req) {
        return bookService.createBook(req);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest req) {
        return bookService.updateBook(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
