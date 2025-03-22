package inheritance;

public class LibraryManagement {
	public static void main(String[] args) {
		LibraryManagementSystem system=new LibraryManagemnetSystem("Student","Madhu","password123");
		system.register();
		system.login();
		
		Student student=new Student("Pravee","S001","12th");
		Staff staff=new Staff("Mr.Styris","M001","Mathematics");
		
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
