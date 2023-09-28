package Q2;

//a class that creates a thread that keeps reading the value in the Repository class and printing it
public class Publisher implements Runnable {

	private Repository repository; // creating instance of Repository

	// constructor of publisher with repository
	public Publisher(Repository repository) {
		this.repository = repository;
	}

	@Override
	public void run() {
		while (true) { // endless loop
			synchronized (repository) { // synchronize on the repository object
				// wait until the repository has been updated
				while (repository.getValue() == -1) {
					try {
						repository.wait();
					} catch (InterruptedException e) {
					}
				}
				System.out.println(repository.getValue()); // print value from repository
				repository.setValue(-1); // update repository value
				repository.notifyAll(); // notify all waiting threads that the repository has been updated
			}
		}
	}
}

/*
 * public Publisher(Repository rep) { repository = rep; this.thread = new
 * Thread(() -> { while (true) {
 * 
 * }
 */

// System.out.println(repository.integer);
//
//

/*
 * try { System.out.println(repository.queue.take()); // take() takes the item
 * if exists, else waits until an items is added } catch (InterruptedException
 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
 * 
 * try { Thread.sleep(800); } catch (InterruptedException e) {
 * e.printStackTrace(); }
 */

/*
 * public void start() { this.thread.start(); } }
 */
