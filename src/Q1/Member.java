package Q1;

public class Member extends Thread {

	// A Library instance variable
	Library theLibrary = new Library();

	// String with a hard coded isbn value of “Ab11228"
	private String isbn = "Ab11228";

	// A constructor which sets the Library with the given value and a name for a member thread
	public Member(Library library, String name) {
		this.setName(name);
		this.theLibrary = library;
	}

	public void run() {
		int index;
		Book book;

		// Synchronizes threads so that only the member who loaned the book can return it 
		synchronized (theLibrary) { // the Library is closed for modifying within other Threads
			
			// Calls findBookIndex using the isbn declared above
			index = theLibrary.findBookIndex(isbn);

			// Calls loanBook using the index returned in a (if not -1) to loan a book
			book = theLibrary.loanBook(index);
		}

		// Sleeps for 2000 milliseconds and then calls returnBook
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (book != null) {
			theLibrary.returnBook(book);
		}

	}

}
