import java.util.LinkedList;
import java.util.Queue;

public class Queue_GenerateBinaryNumber{
    // Method to generate binary numbers from 1 to N using a queue
    public static void generateBinaryNumbers(int N) {
        // Create an empty queue for binary numbers
        Queue<String> queue = new LinkedList<>();
        
        // Start with "1" as the first binary number
        queue.add("1");
        
        // Process binary numbers until we reach N
        while (N-- > 0) {
            // Get the front of the queue and print it
            String binary = queue.poll();
            System.out.print(binary + " ");
            
            // Add the next two binary numbers to the queue
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        // Test the function with an example input
        int N = 5; // You can change this value to test different inputs
        generateBinaryNumbers(N);
    }
}

