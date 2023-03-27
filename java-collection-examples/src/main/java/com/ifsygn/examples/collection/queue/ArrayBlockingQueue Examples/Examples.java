import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Examples {

    public static void main(String[] args) {
        //  (head) <- oooooooooooooooooooooooo <- (tail) FIFO (first in, first out)

        Queue<Integer> q1 = new ArrayBlockingQueue<>(3);

        // Throws NoSuchElement exception --- no items in queue yet
        // System.out.println("Head of queue is: " + q1.element());

        q1.add(10);
        q1.add(20);
        q1.add(30);

        //  if this queue is empty.
        //  element()   -> throws an exception
        //  peek()      -> returns null
        System.out.println("Head of queue is: " + q1.element());

        try {
            //Throws:
            //IllegalStateException – if the element cannot be added at this time due to capacity restrictions
            //ClassCastException – if the class of the specified element prevents it from being added to this queue
            //NullPointerException – if the specified element is null and this queue does not permit null elements
            //IllegalArgumentException – if some property of this element prevents it from being added to this queue.
            q1.add(40);
        } catch (IllegalStateException e) {
            System.out.println("Tried to add too many items to the queue.");
        }

        for(Integer value: q1) {
            System.out.println("Queue value: " + value);
        }

        System.out.println("Removed from queue: " + q1.remove());
        System.out.println("Removed from queue: " + q1.remove());
        System.out.println("Removed from queue: " + q1.remove());

        try {
            System.out.println("Removed from queue: " + q1.remove());
        } catch (NoSuchElementException e) {
            System.out.println("Tried to remove too many items from queue");
        }

        System.out.println("-----------------------------------------------------------------");

        Queue<Integer> q2 = new ArrayBlockingQueue<>(2);

        System.out.println("Queue 2 peek: " + q2.peek());

        //  offer()
        //  Returns: true if the element was added to this queue, else false
        q2.offer(10);
        q2.offer(20);

        System.out.println("Queue 2 peek: " + q2.peek());

        if(q2.offer(30) == false) {
            System.out.println("Offer failed to add third item.");
        }

        for(var val: q2) {
            System.out.println("Queue 2 value: " + val);
        }

        //  poll()
        //  Retrieves and removes the head of this queue, or returns null if this queue is empty.
        System.out.println("Queue 2 poll: " + q2.poll());
        System.out.println("Queue 2 poll: " + q2.poll());
        System.out.println("Queue 2 poll: " + q2.poll());
    }

}