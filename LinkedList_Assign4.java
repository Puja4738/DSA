public class LinkedList_Assign4 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   // Function to segregate even and odd numbers in the linked list
   public Node segregateEvenOdd(Node head) {
    if (head == null) {
        return null; // If the list is empty, return null
    }

    // Initialize pointers for even and odd lists
    Node evenStart = null, evenEnd = null;
    Node oddStart = null, oddEnd = null;
    Node curr = head;

    // Traverse the list and segregate the nodes
    while (curr != null) {
        int value = curr.data;

        // If the current node is even
        if (value % 2 == 0) {
            if (evenStart == null) {
                // First even node
                evenStart = curr;
                evenEnd = evenStart;
            } else {
                // Append to the even list
                evenEnd.next = curr;
                evenEnd = evenEnd.next;
            }
        } else {
            // If the current node is odd
            if (oddStart == null) {
                // First odd node
                oddStart = curr;
                oddEnd = oddStart;
            } else {
                // Append to the odd list
                oddEnd.next = curr;
                oddEnd = oddEnd.next;
            }
        }

        // Move to the next node
        curr = curr.next;
    }

    // If there are no even nodes, return the odd list
    if (evenStart == null) {
        return oddStart;
    }

    // Connect the even list with the odd list
    evenEnd.next = oddStart;

    // End the odd list
    if (oddEnd != null) {
        oddEnd.next = null;
    }

    // Return the head of the modified list (evenStart)
    return evenStart;
}

// Helper function to print the linked list
public void printList(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
}
    public static void main(String[] args) {
        LinkedList_Assign4 list =new LinkedList_Assign4 ();
        Node head=new Node(8);
        head.next=new Node(12);
        head.next.next=new Node(10);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(4);
        head.next.next.next.next.next=new Node(1);
        head.next.next.next.next.next.next=new Node(6);
        head.next.next.next.next.next.next.next=new Node(7);
        System.out.println("Original list :");
        list.printList(head);
        list.segregateEvenOdd(head);
        System.out.println("Modified list (Even followed by odd ) : ");
        list.printList(head);
            
    }
    
}
