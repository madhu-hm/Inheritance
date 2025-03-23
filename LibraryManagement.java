package assignment8;
import java.util.ArrayList;
import java.util.List;
public class LibraryManagement {
	public static void main(String[] args) {
		LibraryManagementSystem system=new LibraryManagementSystem("Student","Madhu","password123");
		system.register();
		system.login();
		
		Student student=new Student("Madhu","S001","12th");
		Staff staff=new Staff("Mr.Harry","M001","Mathematics");
		
		Book book1=new Book("Java Programming","James Gosling","12345","O'Reilly");
		Book book2=new Book("Data Structures","Robert Lafore","67890","Pearson");
		
		LibraryDatabase library=new LibraryDatabase();
		library.addBook(book1);
		library.addBook(book2);
		
		library.displayBooks();
		
		student.getBookInfo(book1);
		book1.bookRequest();
		
		Librarian librarian =new Librarian("Emma","H001","admin123");
		librarian.verifyLibrarian();
		librarian.search("Java");
		
		student.checkAccount();
		student.account.calculateFine();
		
		system.logout();
	}
}

class LibraryManagementSystem{
	String userType;
	String username;
	String password;
	
	public LibraryManagementSystem(String userType,String username,String password) {
		this.userType=userType;
		this.username=username;
		this.password=password;
	}
	
	void login() {
		System.out.println(username+" logged in as "+userType);
	}
	
	void register() {
		System.out.println(username+" registered successfully!");
	}
	
	void logout() {
		System.out.println(username+" logged out.");
	}
}

class Account{
	int noBorrowedBooks,noReservedBooks,noReturnedBooks,noLostBooks;
	double fineAmount;
	
	public Account() {
		this.noBorrowedBooks++;
		this.noReservedBooks=0;
		this.noReturnedBooks=0;
		this.noLostBooks=0;
		this.fineAmount=0;
	}
	
	void calculateFine() {
		fineAmount=noLostBooks*50;
		System.out.println("Total fine: $"+fineAmount);
	}
}

class Book{
	String title,author,ISBN,publication;
	
	public Book(String title,String author,String ISBN,String publication) {
		this.title=title;
		this.author=author;
		this.ISBN=ISBN;
		this.publication=publication;
	}
	
	void showDueDate() {
		System.out.println("Due date for "+title+" is in 14 days.");
	}
	
	void reservationStatus() {
        System.out.println("Book '" + title + "' is available for reservation.");
    }

    void feedback(String feedbackMessage) {
        System.out.println("Feedback for " + title + ": " + feedbackMessage);
    }

    void bookRequest() {
        System.out.println("Request placed for book: " + title);
    }

    void renewInfo() {
        System.out.println("Book " + title + " renewed for 7 more days.");
    }
}

class User{
	String name;
	String id;
	Account account;
	
	public User(String name, String id) {
	  this.name = name;
	  this.id = id;
	  this.account = new Account();
	}

	void verify() {
	   System.out.println("Verifying user: " + name);
	}

	void checkAccount() {
	   System.out.println(name + "'s Account: Borrowed Books = " + account.noBorrowedBooks);
	}

	void getBookInfo(Book book) {
	   System.out.println("Book Info: " + book.title + " by " + book.author);
	}
}

class Staff extends User {
    String dept;

    public Staff(String name, String id, String dept) {
        super(name, id);
        this.dept = dept;
    }
}

class Student extends User {
    String studentClass;

    public Student(String name, String id, String studentClass) {
        super(name, id);
        this.studentClass = studentClass;
    }
}

class Librarian {
    String name;
    String id;
    String password;

    public Librarian(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    void verifyLibrarian() {
        System.out.println("Librarian " + name + " verified.");
    }

    void search(String searchString) {
        System.out.println("Searching books with keyword: " + searchString);
    }
}

class LibraryDatabase {
    List<Book> listOfBooks = new ArrayList<>();

    void addBook(Book book) {
        listOfBooks.add(book);
        System.out.println("Book '" + book.title + "' added to the library.");
    }

    void deleteBook(Book book) {
        listOfBooks.remove(book);
        System.out.println("Book '" + book.title + "' removed from the library.");
    }

    void updateBook(Book oldBook, Book newBook) {
        listOfBooks.remove(oldBook);
        listOfBooks.add(newBook);
        System.out.println("Book '" + oldBook.title + "' updated to '" + newBook.title + "'");
    }

    void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : listOfBooks) {
            System.out.println("- " + book.title + " by " + book.author);
        }
    }

    void searchBook(String search) {
        for (Book book : listOfBooks) {
            if (book.title.contains(search) || book.author.contains(search)) {
                System.out.println("Found: " + book.title + " by " + book.author);
            }
        }
    }
}
