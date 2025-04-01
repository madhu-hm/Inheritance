package inheritance;

class LibraryManagementSystem {
    String userType;
    String username;
    String password;
    
    void login() {}
    void register() {}
    void logout() {}
}

class User {
    String name;
    int id;
    
    void verify() {}
    void checkAccount() {}
    void getBookInfo() {}
}

class Staff extends User {
    String dept;
}

class Student extends User {
    String studentClass;
}

class Account {
    int noBorrowedBooks;
    int noReservedBooks;
    int noReturnedBooks;
    int noLostBooks;
    double fineAmount;
    
    void calculateFine() {}
}

class Book {
    String title;
    String author;
    String isbn;
    String publication;
    
    void showDueDate() {}
    void reservationStatus() {}
    void feedback() {}
    void bookRequest() {}
    void renewInfo() {}
}

class Librarian {
    String name;
    int id;
    String password;
    String searchString;
    
    void verifyLibrarian() {}
    void search() {}
}

class LibraryDatabase {
    String listOfBooks;
    
    void add() {}
    void delete() {}
    void update() {}
    void display() {}
    void search() {}
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.username = "admin";
        system.password = "password";
        system.userType = "Librarian";

        User user = new User();
        user.name = "Madhu";
        user.id = 28;

        Book book = new Book();
        book.title = "Java Programming";
        book.author = "Herbert Schildt";
        book.isbn = "123456789";
        book.publication = "McGraw-Hill";

        Librarian librarian = new Librarian();
        librarian.name = "Ms.Emma";
        librarian.id = 1;

        System.out.println("Library System User: " + system.username);
        System.out.println("User Name: " + user.name);
        System.out.println("User ID: " + user.id);
        System.out.println("Book Title: " + book.title);
        System.out.println("Book Author: " + book.author);
        System.out.println("Book Publication: " + book.publication);
        System.out.println("Librarian: " + librarian.name);
        System.out.println("Librarian ID: " + librarian.id);
        
       }
}
