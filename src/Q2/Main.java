package Q2;

/*
 * Implement three classes: Repository, Counter, and Publisher.
• The Repository class should store an integer.
• The Counter class should create a thread that starts counting from 0 (0, 1, 2, 3 ...) and
stores each value in the Repository class.
• The Publisher class should create a thread that keeps reading the value in the
Repository class and printing it.

Write a program that creates an instance of the Repository class and sets up a Counter and a
Publisher object to operate on it
 */


public class Main {

	public static void main(String[] args) {
		
		Repository repository = new Repository();  // instance of the Repository
		repository.setValue(-1); // set value of repository to -1
		Counter counter = new Counter(repository); // instance of Counter 
		Publisher publisher = new Publisher(repository); // instance of Publisher
		
		// boolean flag = false;
		// Publisher publisher = new Publisher(repository, flag);
		
		Thread counterThread = new Thread(counter); // create counter thread
	    Thread publisherThread = new Thread(publisher); // create publisher thread
		
		counterThread.start(); //start counter thread
		publisherThread.start(); // start publisher thread
		
	}

}
