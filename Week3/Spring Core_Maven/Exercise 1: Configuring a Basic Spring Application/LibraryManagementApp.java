package com.library;

import com.library.service.BookService;
import com.library.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=== Starting Library Management System ===");
        
        // Load Spring Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get beans from Spring container
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        
        // Test the configuration
        System.out.println("Spring beans loaded successfully!");
        System.out.println("BookService: " + bookService);
        System.out.println("BookRepository: " + bookRepository);
        System.out.println("Database name: " + bookRepository.getDatabaseName());
        
        // Test functionality
        bookService.addBook("Spring in Action");
        bookService.searchBook("Clean Code");
        
        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("=== Application Shutdown ===");
    }
}
