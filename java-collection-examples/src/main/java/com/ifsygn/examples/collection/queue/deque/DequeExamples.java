import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExamples {
    public static void main(String[] args)
    {
        /*
            Deque is an interface.
            ArrayDeque and LinkedList implements this interface
         */

        Deque<Integer> arrayDeque = new ArrayDeque<>();
        Deque<Integer> linkedList = new LinkedList<>();

        //add operations
        arrayDeque.add(5);              //Add to the end/tail of the queue
        arrayDeque.offerFirst(7);    //Inserts to at the front/head of this deque
        arrayDeque.offerLast(9);     //Inserts to the end/tail of this deque

        System.out.println(arrayDeque);

        //Print size
        System.out.println("size" + arrayDeque.size());

        //arrayDeque.
    }
}

