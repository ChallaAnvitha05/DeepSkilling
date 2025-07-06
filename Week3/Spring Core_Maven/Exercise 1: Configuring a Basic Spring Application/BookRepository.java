package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private String databaseName;
    private List<Book> books;
    
    // Default constructor
    public BookRepository() {
        this.books = new ArrayList<>();
        initializeSampleData();
    }
    
    // Initialize with sample data
    private void initializeSampleData() {
        books.add(new Book(1L, "Spring in Action", "Craig Walls", "978-1617294945", true));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin", "978-0132350884", true));
        books.add(new Book(3L, "Effective Java", "Joshua Bloch", "978-0134685991", false));
        books.add(new Book(4L, "Java: The Complete Reference", "Herbert Schildt", "978-1260440232", true));
    }
    
    // Save a book
    public void saveBook(Book book) {
        if (book.getId() == null) {
            book.setId(generateId());
        }
        books.add(book);
        System.out.println("Book saved: " + book.getTitle());
    }
    
    // Find book by ID
    public Book findBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    // Find all books
    public List<Book> findAllBooks() {
        return new ArrayList<>(books);
    }
    
    // Find books by title
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(ArrayList::new, (list, book) -> list.add(book), ArrayList::addAll);
    }
    
    // Find books by author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(ArrayList::new, (list, book) -> list.add(book), ArrayList::addAll);
    }
    
    // Find available books
    public List<Book> findAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(ArrayList::new, (list, book) -> list.add(book), ArrayList::addAll);
    }
    
    // Update book availability
    public void updateBookAvailability(Long bookId, boolean available) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setAvailable(available);
            System.out.println("Book availability updated: " + book.getTitle() + " - Available: " + available);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }
    
    // Delete book
    public void deleteBook(Long bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
        System.out.println("Book deleted with ID: " + bookId);
    }
    
    // Generate unique ID
    private Long generateId() {
        return books.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0L) + 1;
    }
    
    // Database connection simulation
    public void connectToDatabase() {
        System.out.println("Connected to database: " + databaseName);
    }
    
    // Getters and setters
    public String getDatabaseName() {
        return databaseName;
    }
    
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    public int getBookCount() {
        return books.size();
    }
}
