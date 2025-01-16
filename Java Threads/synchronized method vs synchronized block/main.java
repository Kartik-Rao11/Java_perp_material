/**
 * Threads are the lightweight process that execute a particular piece of code.
 * Synchorized keyword locks the monitor of the object. Whenever the thread is
 * exectued with synchronized block or method it locks the monitor so that other
 * thread won't execute the synchronized block or method until current thread is
 * executed.
 */

class Counter {
    int count = 0;

    public synchronized void incrementCounter() { // this is synchronized method
        count++;
    }

    public void incrementCounterbyBlock() { // this is synchronized block
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class Task implements Runnable {
    // Runnable interface that gives only run method to implement
    // Advantages of using runnable
    // 1. You get run method which can be directly run passing the object in the
    // thread class
    // 2. You can extend more class as multiple inheritance is not supported.
    private Counter counter;

    Task(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementCounter();
        }
    }

}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // instance of the counter object
        Thread t1 = new Thread(new Task(counter)); // passing the instance of the class that implements runnable
                                                   // interface (Task class) it will run the void run() method in the
                                                   // class
        Thread t2 = new Thread(new Task(counter));

        t1.start(); // starts the thread
        t2.start();
        t1.join(); // this makes sure that our main thread wait for t1 and t2 to finish executing
        t2.join();
        System.out.println("Final Count: " + counter.getCount()); // output 2000 (both the threads execute the block
                                                                  // for 1000 time each)
    }
}