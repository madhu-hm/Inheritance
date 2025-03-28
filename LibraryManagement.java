package assignment8;

import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem system = new LibraryManagementSystem();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Book");
            System.out.println("4. Display Books");
            System.out.println("5. Search Book");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Logout");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.register(scanner);
                    break;
                case 2:
                    system.login(scanner);
                    break;
                case 3:
                    system.addBook(scanner);
                    break;
                case 4:
                    system.displayBooks();
                    break;
                case 5:
                    system.searchBook(scanner);
                    break;
                case 6:
                    system.borrowBook(scanner);
                    break;
                case 7:
                    system.returnBook(scanner);
                    break;
                case 8:
                    system.logout();
                    break;
                case 9:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class LibraryManagementSystem {
    private String loggedInUser = null;
    private final LibraryDatabase library = new LibraryDatabase();
    private final Map<String, String> userDatabase = new HashMap<>();
    
    void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        userDatabase.put(username, password);
        System.out.println(username + " registered successfully!");
    }
    
    void login(Scanner scanner) {
        if (loggedInUser != null) {
            System.out.println("Already logged in as " + loggedInUser);
            return;
        }
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            loggedInUser = username;
            System.out.println(username + " logged in successfully.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
    
    void logout() {
        if (loggedInUser == null) {
            System.out.println("No user is currently logged in.");
        } else {
            System.out.println(loggedInUser + " logged out.");
            loggedInUser = null;
        }
    }
    
    void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter publication: ");
        String publication = scanner.nextLine();
        library.addBook(new Book(title, author, isbn, publication));
    }
    
    void displayBooks() {
        library.displayBooks();
    }
    
    void searchBook(Scanner scanner) {
        System.out.print("Enter book title or author to search: ");
        String search = scanner.nextLine();
        library.searchBook(search);
    }
    
    void borrowBook(Scanner scanner) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        library.borrowBook(title);
    }
    
    void returnBook(Scanner scanner) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        library.returnBook(title);
    }
}

class Book {
    String title, author, ISBN, publication;
    boolean isBorrowed = false;

    public Book(String title, String author, String ISBN, String publication) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publication = publication;
    }
}

class LibraryDatabase {
    private final List<Book> listOfBooks = new ArrayList<>();

    void addBook(Book book) {
        listOfBooks.add(book);
        System.out.println("Book '" + book.title + "' added to the library.");
    }

    void displayBooks() {
        if (listOfBooks.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("Library Books:");
        for (Book book : listOfBooks) {
            System.out.println("- " + book.title + " by " + book.author + (book.isBorrowed ? " (Borrowed)" : ""));
        }
    }

    void searchBook(String search) {
        boolean found = false;
        for (Book book : listOfBooks) {
            if (book.title.toLowerCase().contains(search.toLowerCase()) || book.author.toLowerCase().contains(search.toLowerCase())) {
                System.out.println("Found: " + book.title + " by " + book.author);
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
    }

    void borrowBook(String title) {
        for (Book book : listOfBooks) {
            if (book.title.equalsIgnoreCase(title) && !book.isBorrowed) {
                book.isBorrowed = true;
                System.out.println("You have borrowed: " + book.title);
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    void returnBook(String title) {
        for (Book book : listOfBooks) {
            if (book.title.equalsIgnoreCase(title) && book.isBorrowed) {
                book.isBorrowed = false;
                System.out.println("You have returned: " + book.title);
                return;
            }
        }
        System.out.println("Invalid return. Book was not borrowed.");
    }
}
