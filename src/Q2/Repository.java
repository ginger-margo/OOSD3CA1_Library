package Q2;

// repository class to store an integer
public class Repository {
    private int value;

    // setter method to set the value of repository
    public synchronized void setValue(int value) {
        this.value = value;
    }

    // getter method to get value of repository
    public synchronized int getValue() {
        return value;
    }
}


//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue; 

/*public class Repository {
	
	// public int integer;

	public final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1); // allows to use queue from different threads
}*/
