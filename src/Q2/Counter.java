package Q2;


// class that creates a thread that starts counting from 0 and stores each value in the Repository class

public class Counter implements Runnable {

	private Repository repository;

	public Counter(Repository repository) {
		this.repository = repository;
	}

	public void run() {
		int count = 0;
		while (true) {
			synchronized (repository) { // synchronize on the repository object
				repository.setValue(count); // set the value of the repository to the current count
				count++; // increase count
				repository.notifyAll(); // notify all waiting threads that the count has been updated
			}
			try {
				Thread.sleep(800); // wait 
			} catch (InterruptedException e) {
				// ignore
			}
		}

	}
}

/*
 * public Counter(Repository rep) { repository = rep; this.thread = new
 * Thread(() -> { int i = 0;
 * 
 * while (true) { // pass it to repository try { repository.queue.put(i); //
 * put() blocks the operation if the queue is full } catch (InterruptedException
 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } i++;
 * 
 * 
 * try { Thread.sleep(800); } catch (InterruptedException e) {
 * e.printStackTrace(); } } }); }
 * 
 * 
 * public void start() { this.thread.start(); }
 * 
 * }
 * 
 */
///// !!!!!!!!!!!!!!!!!!!!!!!!!!!
// !!!!!!!!!!!!!!!!!!!!!!!!!!

// !!!!!!!!!!!!!!!!!!!!!!!!!
