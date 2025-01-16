/**
 * Deadlock in java -> when two or more thread lock resource wait for each other
 * to finish
 */

class Resource { // our resource class with some methods
    public synchronized void methodA() {
        // do something
    }

    public synchronized void methodB() {
        // Do something
    }
}

class DeadLockClass {
    public static void main(String[] args) {
        Resource resource1 = new Resource(); // getting two instances of the resource class
        Resource resource2 = new Resource();
        Thread t1 = new Thread(() -> { // ()-> this is lambda function this an alternative to defining an interface it
                                       // substitutes the new Runnable{void run(){//code that's to executed}}

            synchronized (resource1) { // this accquire lock on resource1 instance. -> no thread can interfere with
                                       // resource1 untile thread 1 execution finishes
                System.out.println(Thread.currentThread().getName() + " Accquired lock on resource 1");
                // these methods return the thread name
                try {
                    Thread.sleep(1000); // put the thread 1 in sleep mode. It will allow the execution of thread 2 but
                                        // thread 1 still has'nt released the resource1
                } catch (Exception e) {
                    // TODO: handle exception
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " Accquired lock on resource 2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                // Thread 2 will run when thread 1 will go to sleep
                System.out.println(Thread.currentThread().getName() + " Accquired lock on resource 2");
                try {
                    Thread.sleep(1000); // after it goes to sleep both the thread will wait for each other to release
                                        // resources so that the can use the resource
                } catch (Exception e) {
                    // TODO: handle exception
                }

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " Accquired lock on resource 1");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}