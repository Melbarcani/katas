package com.example.api_secure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title can be up to 100 characters long")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author can be up to 100 characters long")
    private String author;

    @NotBlank(message = "Published Date is mandatory")
    private String publishedDate;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Getters and setters
}

