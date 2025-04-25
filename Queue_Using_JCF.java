import java.util.*;

public class Queue_Using_JCF {
    public static void main(String[] args) {
        // Correct initialization of a Queue using LinkedList
        Queue<Integer> q = new ArrayDeque<>();  
        
        // Adding elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);
        
        // Processing the queue and printing elements
        while (!q.isEmpty()) {
            System.out.println(q.peek());  // Prints the element at the front of the queue
            q.remove();                    // Removes the front element
        }
    }
}

