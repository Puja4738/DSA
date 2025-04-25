import java.util.Stack;

public class Stack_Assign1_PalindromeLL {

    // Make Node class static so it can be used in static methods
    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) {
        Stack<Character> s = new Stack<>();
        Node temp = head;
        
        // Push all characters to the stack
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        
        // Traverse the list again and compare with the stack
        temp = head;
        while (temp != null) {
            if (s.pop() != temp.data) {
                return false; // If mismatch found, return false
            }
            temp = temp.next;
        }
        return true; // If no mismatch, it's a palindrome
    }

    public static Node addToList(Node head, char data) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public static void main(String[] args) {
        Node head = null; // Initialize head of the linked list
        
        // Add nodes to the list
        head = addToList(head, 'A');
        head = addToList(head, 'B');
        head = addToList(head, 'C');
        head = addToList(head, 'B');
        head = addToList(head, 'A');

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("Yes, it is a palindrome.");
        } else {
            System.out.println("No, it is not a palindrome.");
        }
    }
}
