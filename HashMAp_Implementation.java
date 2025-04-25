import java.util.*;

public class HashMAp_Implementation {

    static class HashMap<K, V> {
        // Node class representing each key-value pair
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N; // Size of the hash map (number of buckets)
        private int n; // Number of key-value pairs stored in the hash map
        private ArrayList<LinkedList<Node>> buckets; // ArrayList of linked lists (buckets)

        // Constructor
        public HashMap() {
            this.N = 4; // Initial number of buckets
            this.buckets = new ArrayList<>(N); // Initialize the ArrayList with initial capacity
            // Initialize each bucket with an empty LinkedList
            for (int i = 0; i < N; i++) {
                this.buckets.add(new LinkedList<>()); // Each bucket is a LinkedList
            }
        }

        // Hash Function
        public int hashFunction(K key) {
            int hc = key.hashCode(); // Get the hash code of the key
            return Math.abs(hc) % N; // Use modulo operation to find the index within buckets
        }

        // Search in LinkedList (returns the index of the node in the bucket's LinkedList)
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets.get(bi); // Access the bucket at index bi
            int di = 0; // Data index (position in LinkedList)
            for (Node node : ll) {
                if (node.key.equals(key)) { // Use .equals for key comparison
                    return di;
                }
                di++;
            }
            return -1; // Key not found in the LinkedList
        }

        // Rehash Function (doubles the size of the bucket array and rehashes all key-value pairs)
        private void rehash() {
            ArrayList<LinkedList<Node>> oldBuckets = buckets; // Save current buckets
            buckets = new ArrayList<>(N * 2); // Create a new ArrayList with double the size
            N = 2 * N; // Update the size N
            for (int i = 0; i < N; i++) {
                buckets.add(new LinkedList<>()); // Initialize new buckets
            }

            // Rehash all key-value pairs into new buckets
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value); // Re-put key-value pairs into new buckets
                }
            }
        }

        // Put function (adds or updates a key-value pair)
        public void put(K key, V value) {
            int bi = hashFunction(key); // Get bucket index using hash function
            int di = searchInLL(key, bi); // Search for the key in the LinkedList at bucket index
            if (di != -1) { // If the key exists, update its value
                Node node = buckets.get(bi).get(di);
                node.value = value;
            } else { // If the key does not exist, add a new node
                buckets.get(bi).add(new Node(key, value));
                n++; // Increment number of key-value pairs
            }

            // Check load factor and rehash if necessary
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash(); // Rehash if load factor exceeds threshold
            }
        }

        // Containskey
        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key,bi);

            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }

        // Remove function
        public V remove (K key){
            int bi=hashFunction(key);
            int di=searchInLL(key,bi);

            if(di!=-1){
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        // Get function
        public V get(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key,bi);

            if(di!=-1){
                Node node=buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        // KeySet function to return all keys in the hash map
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key); // Add each key to the keySet
                }
            }
            return keys;
        }

        // IsEmpty function (checks if the hash map is empty)
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("China", 150);
        map.put("India", 100);
        map.put("US", 50);
        map.put("Indonesia", 157);
        map.put("SriLanka", 200);
        map.put("Bhutan", 530);

        // Get and print all keys
        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
