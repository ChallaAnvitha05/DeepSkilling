package com.library.repository;

public class BookRepository {
    private String databaseName;
    
    public BookRepository() {
        System.out.println("BookRepository created");
    }
    
    public void saveBook(String title) {
        System.out.println("Saving book: " + title + " to database: " + databaseName);
    }
    
    public void findBook(String title) {
        System.out.println("Finding book: " + title + " in database: " + databaseName);
    }
    
    // Setter for Spring dependency injection
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    public String getDatabaseName() {
        return databaseName;
    }
}
