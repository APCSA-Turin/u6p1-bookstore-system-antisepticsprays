package com.example.project;

import java.util.Scanner;

public class LibraryInterface {
    // main entry point for the library interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner to read user input
        BookStore bookStore = new BookStore(); // creates a new BookStore object

        boolean running = true; // flag to keep the application running
        
        // main loop to interact with the user
        while (running) {
            System.out.println("\n*****************************************************");
            System.out.println("*******Welcome to the Brooklyn Tech's Library!*******");
            System.out.println("*****************************************************");
            System.out.println("Select From The Following Options:");
            System.out.println("Press 0 to Exit Application.");
            System.out.println("Press 1 to Add New Book.");
            System.out.println("Press 2 to Upgrade Quantity of a Book.");
            System.out.println("Press 3 to Search a Book.");
            System.out.println("Press 4 to Show All Books.");
            System.out.println("Press 5 to Register Student.");
            System.out.println("Press 6 to Show All Registered Students.");
            System.out.println("Press 7 to Check Out Book.");
            System.out.println("Press 8 to Check In Book.");
            System.out.println("*****************************************************");

            int choice = scanner.nextInt(); // reads the user's menu choice
            scanner.nextLine(); // resets the newline

            if (choice == 0) {
                System.out.println("goodbye. --brooklyn technical highschool's 14 library monitors");
                running = false; // exits the loop to end the application
            } else if (choice == 1) {
                // adds a new book to the library
                System.out.print("Enter Book Name: ");
                String bookName = scanner.nextLine();
                System.out.print("Enter Author Name: ");
                String authorName = scanner.nextLine();
                System.out.print("Enter Year Published: ");
                int yearPublished = scanner.nextInt();
                scanner.nextLine(); // resets the newline
                System.out.print("Enter ISBN of Book: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter Quantity of Books: ");
                int quantity = scanner.nextInt();

                Book newBook = new Book(bookName, authorName, yearPublished, isbn, quantity);
                bookStore.addBook(newBook); // adds the new book to the store
                System.out.println("Book added successfully");
            } else if (choice == 2) {
                // upgrades the quantity of an existing book
                System.out.print("Enter ISBN of Book to Update Quantity: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter Additional Quantity: ");
                int additionalQuantity = scanner.nextInt();

                for (Book book : bookStore.getBooks()) {
                    if (book != null && book.getIsbn().equals(isbn)) {
                        book.setQuantity(book.getQuantity() + additionalQuantity); // updates the quantity
                        System.out.println("Book quantity updated successfully");
                    }
                }
            } else if (choice == 3) {
                // searches for a book by ISBN
                System.out.print("Enter ISBN of Book to Search: ");
                String isbn = scanner.nextLine();

                boolean found = false;
                for (Book book : bookStore.getBooks()) {
                    if (book != null && book.getIsbn().equals(isbn)) {
                        System.out.println(book.bookInfo()); // prints the book's info
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Book not found"); // notifies the user if the book isn't found
                }
            } else if (choice == 4) {
                // shows all books in the library
                System.out.println("Books in the Library:");
                System.out.println(bookStore.bookStoreBookInfo()); // lists all books
            } else if (choice == 5) {
                // registers a new student
                System.out.print("Enter Student Name: ");
                String studentName = scanner.nextLine();
                String studentId = IdGenerate.getCurrentId(); // generates a new student ID
                IdGenerate.generateID(); // generates the next available ID

                User newUser = new User(studentName, studentId); // creates a new user
                bookStore.addUser(newUser); // adds the new user to the store
                System.out.println("Student registered successfully with ID: " + studentId);
            } else if (choice == 6) {
                // displays all registered students
                System.out.println("Registered Students:");
                System.out.println(bookStore.bookStoreUserInfo()); // lists all users
            } else if (choice == 7) {
                // allows a student to check out a book
                System.out.print("Enter Student ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter ISBN of Book to Check Out: ");
                String isbn = scanner.nextLine();

                for (User user : bookStore.getUsers()) {
                    if (user != null && user.getId().equals(userId)) {
                        for (Book book : bookStore.getBooks()) {
                            if (book != null && book.getIsbn().equals(isbn) && book.getQuantity() > 0) {
                                for (int i = 0; i < user.getBooks().length; i++) {
                                    if (user.getBooks()[i] == null) {
                                        user.getBooks()[i] = book; // adds the book to the user's books
                                        book.setQuantity(book.getQuantity() - 1); // reduces the book quantity
                                        System.out.println("Book checked out successfully!");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (choice == 8) {
                // allows a student to check in a book
                System.out.print("Enter Student ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter ISBN of Book to Check In: ");
                String isbn = scanner.nextLine();

                for (User user : bookStore.getUsers()) {
                    if (user != null && user.getId().equals(userId)) {
                        for (int i = 0; i < user.getBooks().length; i++) {
                            if (user.getBooks()[i] != null && user.getBooks()[i].getIsbn().equals(isbn)) {
                                user.getBooks()[i].setQuantity(user.getBooks()[i].getQuantity() + 1); // restores the book's quantity
                                user.getBooks()[i] = null; // removes the book from the student's checked-out list
                                System.out.println("Book checked in successfully");
                                break;
                            }
                        }
                    }
                }
            } else {
                // handles invalid options
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}