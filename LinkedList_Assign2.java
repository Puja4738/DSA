public class LinkedList_Assign2 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   // Function to delete N nodes after M nodes of a linked list
   public static void deleteNAfterM(Node head, int M, int N) {
    Node current = head;

    while (current != null) {
        // Retain M nodes
        for (int i = 1; i < M && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        // Now current points to the M-th node, we need to delete the next N nodes
        Node temp = current.next;
        for (int i = 1; i <= N && temp != null; i++) {
            temp = temp.next;
        }

        // Link the (M)-th node to the (M + N + 1)-th node
        current.next = temp;

        // Move the current pointer to the (M + N + 1)-th node
        current = temp;
    }
}

// Helper function to print the linked list
public static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
}
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node (2);
        head.next.next=new Node (3);
        head.next.next.next=new Node (4);
        head.next.next.next.next=new Node (5);
        head.next.next.next.next.next=new Node (6);
        head.next.next.next.next.next.next=new Node (7);
        head.next.next.next.next.next.next.next=new Node (8);

        System.out.println("Original List: ");
        printLL(head);
        int M=2,N=2;
        deleteNAfterM(head,M,N);
        System.out.println("Modified List after deleting " + N +" nodes after every " + M +" nodes : ");
        printLL(head);
        
    }
    
}
