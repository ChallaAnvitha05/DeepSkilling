package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService created");
    }
    
    public void addBook(String title) {
        System.out.println("BookService: Adding book - " + title);
        bookRepository.saveBook(title);
    }
    
    public void searchBook(String title) {
        System.out.println("BookService: Searching for book - " + title);
        bookRepository.findBook(title);
    }
    
    // Setter for Spring dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository dependency injected into BookService");
    }
    
    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
