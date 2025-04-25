public class LinkedList_Assign5 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Function to merge two sorted linked lists
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Create a dummy node to simplify merging process
        Node dummy = new Node(0);
        Node current = dummy;

        // Merge the two lists by comparing the values
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from either list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;  // Return the merged list (skipping the dummy node)
    }

    // Function to merge k sorted linked lists using divide and conquer
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    // Helper function for divide and conquer
    private Node mergeKListsHelper(Node[] lists, int left, int right) {
        // Base case: If there's only one list, return it
        if (left == right) {
            return lists[left];
        }

        // Divide the range into two halves and merge them recursively
        int mid = left + (right - left) / 2;
        Node l1 = mergeKListsHelper(lists, left, mid);        // Merge the left half
        Node l2 = mergeKListsHelper(lists, mid + 1, right);   // Merge the right half

        // Merge the two halves
        return mergeTwoLists(l1, l2);
    }

    // Utility function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        
        LinkedList_Assign5 listed= new LinkedList_Assign5();
        // Create first sorted linked list: 1->3->NULL
        Node l1 = new Node(1);
        l1.next = new Node(3);

        // Create second sorted linked list: 6->8->NULL
        Node l2 = new Node(6);
        l2.next = new Node(8);

        // Create third sorted linked list: 9->10->NULL
        Node l3 = new Node(9);
        l3.next = new Node(10);

        // Array of linked lists
        Node[] lists = new Node[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        // Merge all linked lists
        Node mergedHead = listed.mergeKLists(lists);

        // Print the merged sorted linked list
        System.out.println("Merged Sorted List:");
        listed.printList(mergedHead);
    }
}
