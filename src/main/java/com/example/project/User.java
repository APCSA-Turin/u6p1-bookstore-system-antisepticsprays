package com.example.project;

public class User {
    //requires 3 private attributes: String name, String Id, Book[] bookList initialized to an empty array of 5 books
    private String name;  // stores the name of the user
    private String Id;    // stores the ID of the user
    private Book[] bookList = new Book[5];  // an array of Book objects, initialized with a capacity for 5 books

    //requires 1 constructor with two parameters that initialize name and id
    public User(String name, String Id) {
        this.name = name;  // initialize the user's name
        this.Id = Id;      // initialize the user's ID
    }

    // getter for name
    public String getName() {
        return name;  // returns the name of the user
    }

    // setter for name
    public void setName(String newName) {
        name = newName;  // updates the user's name
    }

    // getter for Id
    public String getId() {
        return Id;  // returns the ID of the user
    }

    // setter for Id
    public void setId(String newId) {
        Id = newId;  // updates the user's ID
    }

    // getter for bookList
    public Book[] getBooks() {
        return bookList;  // returns the book list of the user
    }

    // setter for bookList
    public void setBooks(Book[] newBookList) {
        bookList = newBookList;  // sets a new book list for the user
    }

    // returns a list of books for the user, outputs "empty" if no books are assigned
    public String bookListInfo() {
        String str = "";  // initializes an empty string to store book info
        for (Book book : bookList) {  // iterates through the bookList array
            if (book == null) {
                str += "empty\n";  // adds "empty" if no book is present
            } else {
                str += book.bookInfo() + "\n";  // adds the book's information if present
            }
        }
        return str;  // returns the list of books or "empty" messages
    }

    // returns the user’s info: name, ID, and their book list
    public String userInfo() {
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();  // formats user info for display
    }
}