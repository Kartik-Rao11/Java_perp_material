/**
 * To aviod deadlock
 * 1. Make sure all threads acquire lock in consistent order
 * 2. Use synchronized block instead of method where fine controls is required.
 * 3. One thread should execute single resource synchronized block
 */
class SafeResource {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) { // acquring locks in same order lock 1
            System.out.println(Thread.currentThread().getName() + "Acquired lock on resource 1 from method A");
            synchronized (lock2) { // acquring locks in same order lock 2
                System.out.println(Thread.currentThread().getName() + "Acquired lock on resource 2 from method A");
            }
        }
    }

    public void methodB() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "Acquired lock on resource 1 from method B");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "Acquired lock on resource 2 from method B");
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        SafeResource safeResource = new SafeResource();
        Thread t1 = new Thread(safeResource::methodA);
        // safeResource::methodA -> method reference in java. It's alternate to use
        // lambda expression where method matches a functional interface in this case
        // runnable interface signature void run(). That's why safeResource doesnt
        // implement Runnable class
        Thread t2 = new Thread(safeResource::methodB);// equivalent code -> Thread t2 = new Thread(()->
                                                      // safeResource.methodB());
        t1.start();
        t2.start();
    }
}