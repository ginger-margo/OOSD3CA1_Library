package Q1;
import java.util.ArrayList;

public class Library {
	
	// Q1 1) An instance variable that is a collection used to store Book objects
	ArrayList<Book> myLibrary = new ArrayList<Book>();

	/* Q1 5) A main method which
	 * 
	 * a. Creates a Library object, creates a Book with an isbn value of “Ab11228” and
	 * other parameters of your choice. Adds the book created to the library
	 * collection.
	 * 
	 * b. Creates two Member objects and starts both threads
	 */
	public static void main(String[] args) {
		Library theLibrary = new Library(); // creating an instance of the Library class
		Book book = new Book("Ivan", "Turgenev", "Ab11228", 1862); // creating a book with some data 
		theLibrary.returnBook(book); // adding the book to the library with the return method
		
		Member member1 = new Member(theLibrary, "Member 1"); // creating the members threads, passing them the library 
		Member member2 = new Member(theLibrary, "Member 2"); // and a name for identification
		
		member1.start(); // starting the threads
		member2.start();

	}

	/*
	 * Q1 2) A method called findBookIndex that searches the Book collection for a
	 * book using the given an ISBN (String) as a parameter and returns the index
	 * (int) of the collection where the book is located or -1 if not found
	 */
	public int findBookIndex(String ISBN) {
		
		// finding the book with the matching ISBN and returning the index of that book
		for (Book currentBook : myLibrary) { 
			if (currentBook.getIsbn().equals(ISBN)) { 
				return myLibrary.indexOf(currentBook);
			}

		}
		return -1; // returning -1 if book is not found
	}

	// A method called loanBook which loans a Book by removing it from the
	// collection
	// using the given index (int) parameter and returns it (Book). It returns null
	// if the book
	// is not in the collection
	public Book loanBook(int index) {
		
		// if the index of the book is within the library list than we loan the book to the current thread and remove it from the library
		if (index >= 0 && index < myLibrary.size()) {
			System.out.println("Book loaned for " + Thread.currentThread().getName()); // calling method getName() on the current thread to get
			// the name of the thread
			return myLibrary.remove(index);
		} else {
			return null;
		}
		
	}

	// A method called returnBook which adds the given Book (parameter) back into
	// the
	// collection
	public void returnBook(Book book) {
		System.out.println("Book returned for " + Thread.currentThread().getName()); 
		myLibrary.add(book);
	}

}
