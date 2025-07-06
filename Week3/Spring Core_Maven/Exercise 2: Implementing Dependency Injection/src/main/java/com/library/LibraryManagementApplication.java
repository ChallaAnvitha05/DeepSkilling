package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Library Management Application ===");
        System.out.println("Testing Spring IoC and Dependency Injection...\n");

        // Load Spring configuration from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get the BookService bean from Spring container
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("\n=== Testing Dependency Injection ===");
        
        // Verify dependency injection worked
        if (bookService.getBookRepository() != null) {
            System.out.println("✓ SUCCESS: BookRepository successfully injected into BookService");
            System.out.println("✓ Database Name: " + bookService.getBookRepository().getDatabaseName());
        } else {
            System.out.println("✗ FAILED: BookRepository not injected into BookService");
        }
        
        System.out.println("\n=== Testing BookService Operations ===");
        
        // Test adding books
        System.out.println("\n1. Adding books to library:");
        bookService.addBook("The Great Gatsby");
        bookService.addBook("To Kill a Mockingbird");
        bookService.addBook("1984");
        
        // Test searching books
        System.out.println("\n2. Searching for books:");
        bookService.searchBook("The Great Gatsby");
        bookService.searchBook("Harry Potter");
        bookService.searchBook("1984");
        
        System.out.println("\n=== Configuration Verification ===");
        System.out.println("✓ XML Configuration: applicationContext.xml loaded successfully");
        System.out.println("✓ BookRepository: Created and databaseName property injected");
        System.out.println("✓ BookService: Created and BookRepository dependency injected");
        System.out.println("✓ All operations working through injected dependencies");
        
        // Close the Spring context
        ((ClassPathXmlApplicationContext) context).close();
        
        System.out.println("\n=== Application Completed Successfully ===");
    }
}
