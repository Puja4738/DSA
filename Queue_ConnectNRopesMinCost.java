import java.util.*;
public class Queue_ConnectNRopesMinCost {
    public static int minCost(int[] arr, int n) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all the ropes to the priority queue
        for (int rope : arr) {
            pq.add(rope);
        }

        // Initialize the total cost to 0
        int totalCost = 0;

        // Continue until we have one rope left in the heap
        while (pq.size() > 1) {
            // Extract the two smallest ropes
            int first = pq.poll();
            int second = pq.poll();

            // The cost to connect these two ropes
            int cost = first + second;

            // Add the cost to the total cost
            totalCost += cost;

            // Insert the combined rope back into the heap
            pq.add(cost);
        }

        // The total cost is now the answer
        return totalCost;
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        int n=arr.length;
        System.out.println(("Total(min) cost for connect ropes : " +minCost(arr, n)));
    }
    
}
