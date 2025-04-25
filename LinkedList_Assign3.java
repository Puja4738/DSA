public class LinkedList_Assign3 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Function to swap nodes x and y in the linked list by changing links
    public void swapNodes(Node head, int x, int y) {
        // If x and y are the same, no need to swap
        if (x == y) {
            return;
        }

        // Search for x (keep track of current and previous nodes)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of current and previous nodes)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, no swapping can be done
        if (currX == null || currY == null) {
            return;
        }

        // If x is not the head of the linked list, update its previous node's next to y
        if (prevX != null) {
            prevX.next = currY;
        } else {
            // Make y the new head
            head = currY;
        }

        // If y is not the head of the linked list, update its previous node's next to x
        if (prevY != null) {
            prevY.next = currX;
        } else {
            // Make x the new head
            head = currX;
        }

        // Swap the next pointers of currX and currY
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
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
    LinkedList_Assign3 list=new LinkedList_Assign3 ();
    Node head=new Node(1);
    head.next=new Node(2);
    head.next.next=new Node(3);
    head.next.next.next=new Node(4);
    System.out.println("Original list :");
    list.printList(head);
    int x=2,y=4;
    list.swapNodes(head,x,y);
    System.out.println("Modified list after swapping " +x +"and" +y +":");
    list.printList(head);

        
    }
    
}
