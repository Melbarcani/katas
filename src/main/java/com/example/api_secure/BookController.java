package com.example.api_secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@Valid @RequestBody Book book) {
        System.out.println("create");
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        System.out.println("OK");
        var a =  bookService.getAllBooks();
        for (Book b : a) {
            System.out.println(b.getTitle());
        }
        return a;
    }
}

