// import java.util.*;
public class DoublyLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public int  size;

    // Add first in Doubly LinkedList

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        
    }

    // Add last in Doubly Linked List

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.next=null;
        tail=newNode;
    }

// print doubly LinkedList

    public void printDLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print (temp.data +" <-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    // RemoveFirst in Doubly LinkedList

    public int removeFirst(){
        if(head==null){
            System.out.println("LL is empty ");
            return Integer.MIN_VALUE;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    // RemoveLast in Doubly LinkedList

    public int removeLast(){

        if(head==null){
            System.out.println("LL is empty ");
            return Integer.MIN_VALUE;
        }
        if (head == tail) {  // Check if the list has only one node
            int val = head.data;
            head = null;
            tail = null;
            size--;
            return val;
        } 
        Node temp = head;
    // Traverse to the second-to-last node
    while (temp.next != tail) {
        temp = temp.next;
    }

    int val = tail.data;  // Get the data from the last node
    tail = temp;  // Update the tail to the second-to-last node
    tail.next = null;  // Remove the reference to the old tail
    if (tail != null) {
        tail.prev = null;  // Update the prev pointer of the new tail
    }
    size--;
    return val;
}

// Reverse Doubly Linkedlist

public void reverse(){
    Node curr=head;
    Node prev=null;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        curr.prev=next;
        prev=curr;
        curr=next;
    }
    head=prev;
}







    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addLast(7);
        dll.printDLL();
        System.out.println(dll.size);

        dll.removeFirst();
        dll.printDLL();
        System.out.println(dll.size);

        dll.removeLast();
        dll.printDLL();
        System.out.println(dll.size);

        dll.reverse();
        dll.printDLL();
        System.out.println(dll.size);
        
    }
    
}
