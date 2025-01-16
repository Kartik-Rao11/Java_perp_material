package Collections.priority_queue;

import java.util.PriorityQueue;

/**
 * Java priority queue -> It is a queue that has elements in it's natural order.
 * If they implement the default comparable interface use method compareTo. It
 * is implemented min-priority heap. custom odering of the objects can be
 * performed with custom comparator.
 * Time complexity for enqueue and dequeue -> O(logn) n is the number of
 * elements in the heap
 * It does'nt allow null values.
 * Not thread safe
 */

class Task implements Comparable<Task> {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task obj) {
        return Integer.compare(this.priority, obj.priority);
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }

}

public class Main {

    public static void main(String[] args) {
        // PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.reverseOrder()); to
        // reverse the order of the priority queue
        PriorityQueue<Task> pq = new PriorityQueue<>();
        pq.add(new Task("Task 1", 3));
        pq.add(new Task("Task 2", 1));
        pq.add(new Task("Task 3", 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        /**
         * Output
         * Tasks in PriorityQueue: [Task2 (Priority: 1), Task1 (Priority: 3), Task3
         * (Priority: 2)]
         * Processing: Task 2 (Priority: 1)
         * Processing: Task 3 (Priority: 2)
         * Processing: Task 1 (Priority: 3)
         * 
         */
    }

}
