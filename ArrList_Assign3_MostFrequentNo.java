import java.util.*;
public class ArrList_Assign3_MostFrequentNo {
    public static int mostFrequentNo(ArrayList<Integer> nums, int key) {
        // Array to keep track of the frequency of numbers following the key
        int result[] = new int[1000]; // Assumes numbers are within the range 1 to 1000
        
        // Iterate through the list to count frequencies of numbers following the key
        for (int i = 0; i < nums.size(); i++) {
            // Check if the current element is the key
            if (nums.get(i) == key) {
                // Ensure the next element exists to avoid IndexOutOfBoundsException
                if (i + 1 < nums.size()) {
                    // Get the next number and increment its count in the result array
                    result[nums.get(i + 1) - 1]++;
                }
            }
        }
        
        // Find the number with the maximum frequency
        int max = Integer.MIN_VALUE; // Initialize max frequency with the lowest possible value
        int ans = 0; // Variable to store the most frequent number
        
        // Iterate through the result array to find the most frequent number
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i]; // Update max frequency
                ans = i + 1; // Update the answer to the current number
            }
        }
        
        return ans; // Return the most frequent number
    }

    public static void main(String[] args) {
        // Create an ArrayList and add sample numbers
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);   // Key
        nums.add(100); // Number following key
        nums.add(200); // Not following key
        nums.add(1);   // Key
        nums.add(100); // Number following key
        
        int key = 1; // Define the key whose following numbers we are interested in
        int Result = mostFrequentNo(nums, key); // Call the method to get the most frequent number
        System.out.println(Result); // Print the result
    
        
    }
    
}
