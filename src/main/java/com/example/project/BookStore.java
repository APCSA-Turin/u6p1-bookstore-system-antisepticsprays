package com.example.project;

public class BookStore {
    //requires at least 2 attributes: Book[] books, User[] users (initialized to an empty array of 10 max users)
    private Book[] books;
    private User[] users = new User[10];

    //requires 1 empty constructor
    public BookStore() {}

    // getter and setter for users
    public User[] getUsers() {
        return users; // returns the current list of users
    }

    public void setUsers(User[] newUsers) {
        users = newUsers; // updates the list of users with new users
    }

    // getter for books
    public Book[] getBooks() {
        return books; // returns the current list of books
    }

    // add a user
    public void addUser(User user) {
        int index = 0;
        // find the next available slot for a user
        while (index < users.length && users[index] != null) {
            index++;
        }
        if (index < users.length) {
            users[index] = user; // assigns the user to the available slot
        }
    }

    // remove a user and consolidate
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            // find the user by ID and remove
            if (users[i] != null && users[i].getId().equals(user.getId())) {
                users[i] = null; // sets the user to null
                consolidateUsers(); // consolidates the array to remove the null slot
                break;
            }
        }
    }

    // consolidate users
    public void consolidateUsers() {
        User[] tempArray = new User[users.length];
        int index = 0;
        // copy non-null users to a new array
        for (User user : users) {
            if (user != null) {
                tempArray[index] = user;
                index++;
            }
        }
        users = tempArray; // updates the user list with the consolidated array
    }

    // consolidate books
    public void consolidateBooks() {
        int newSize = 0;
        // count non-null books to determine the new size
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                newSize++;
            }
        }
    
        // if it's not empty, organizes non-null books
        Book[] newBooks = new Book[newSize];
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                newBooks[index++] = books[i]; // add non-null books to the new array
            }
        }
    
        books = newBooks; // update the books array with the newly consolidated list
    }

    // add a book
    public void addBook(Book book) {
        // nullpointerexception fix if books array is uninitialized
        if (books == null) {
            books = new Book[0]; // initialize books array if it's null
        }
        Book[] tempArray = new Book[books.length + 1];
        // copy existing books into the new array
        for (int i = 0; i < books.length; i++) {
            tempArray[i] = books[i];
        }
        tempArray[books.length] = book; // add the new book at the end
        books = tempArray; // update the books array with the new book
    }

    // insert a book at a specific index
    public void insertBook(Book book, int index) {
        Book[] tempArray = new Book[books.length + 1];
        // copy books before the specified index
        for (int i = 0; i < index; i++) {
            tempArray[i] = books[i];
        }
        // insert the new book at the specified index
        tempArray[index] = book;
        // copy the rest of the books, shifting them by 1
        for (int i = index; i < books.length; i++) {
            tempArray[i + 1] = books[i];
        }
        books = tempArray; // update the books array with the new arrangement
    }

    // remove a book
    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                // if quantity is greater than 1, decrease the quantity
                if (books[i].getQuantity() > 1) {
                    books[i].setQuantity(books[i].getQuantity() - 1);
                } else {
                    books[i] = null; // set book to null if there's only one book
                }
            }
        }
        // consolidate the book array to clean up any null entries
        consolidateBooks();
    }
    
    // returns information about books in the store
    public String bookStoreBookInfo() {
        if (books == null || books.length == 0) {
            return "No books available."; // return message if no books are available
        }
        String info = "";
        // append information of each book to the string
        for (Book book : books) {
            if (book != null) {
                info += book.bookInfo() + "\n"; // add book information to the string
            }
        }
        return info; // return the formatted string
    }

    // returns information about users in the store
    public String bookStoreUserInfo() {
        String info = "";
        // append information of each user to the string
        for (User user : users) {
            if (user != null) {
                info += user.userInfo() + "\n"; // add user information to the string
            }
        }
        return info; // return the formatted string
    }
}