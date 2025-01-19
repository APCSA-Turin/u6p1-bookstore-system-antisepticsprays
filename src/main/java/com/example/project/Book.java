package com.example.project;

public class Book {
    //requires 5 attributes: String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //requires 1 constructor with 5 arguments that initialize the attributes of the class
    public Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title; // initializes title
        this.author = author; // initializes author
        this.yearPublished = yearPublished; // initializes yearPublished
        this.isbn = isbn; // initializes isbn
        this.quantity = quantity; // initializes quantity
    }

    // getter for title
    public String getTitle() {
        return title; // returns the title of the book
    }

    // setter for title
    public void setTitle(String newTitle) {
        title = newTitle; // sets a new title for the book
    }

    // getter for author
    public String getAuthor() {
        return author; // returns the author of the book
    }

    // setter for author
    public void setAuthor(String newAuthor) {
        author = newAuthor; // sets a new author for the book
    }

    // getter for yearPublished
    public int getYearPublished() {
        return yearPublished; // returns the year the book was published
    }

    // setter for yearPublished
    public void setYearPublished(int newYearPublished) {
        yearPublished = newYearPublished; // sets a new year for when the book was published
    }

    // getter for isbn
    public String getIsbn() {
        return isbn; // returns the ISBN number of the book
    }

    // setter for isbn
    public void setIsbn(String newIsbn) {
        isbn = newIsbn; // sets a new ISBN for the book
    }

    // getter for quantity
    public int getQuantity() {
        return quantity; // returns the quantity of the book
    }

    // setter for quantity
    public void setQuantity(int newQuantity) {
        quantity = newQuantity; // sets a new quantity for the book
    }

    // returns book information as a formatted string
    public String bookInfo(){
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
        // returns a string representation of the book with all its attributes
    }
}