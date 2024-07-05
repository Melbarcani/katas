package com.example.api_secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {

        var b =  bookRepository.save(book);
        System.out.println("Book created");
        return b;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

