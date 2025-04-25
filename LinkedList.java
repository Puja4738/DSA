// import java.util.LinkedList;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // Add operation

    // Add element at head -> O(1)
    public void addFirst(int data){
        // create new node
        Node newNode=new Node(data);
        size++;
        // basecase
        if(head==null){
            head=tail=newNode;
            return;
        }
        // new node's next=head
        newNode.next=head;
        // head=newNode
        head=newNode;
    }

    // Add element at tail -> O(1)
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;

    }
    
    // Print linkedList element ->O(n)
    public void printLL(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data +"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    // Add element in the middle -> O(n)
    public void addNodeAtMiddle(int index,int data){
        Node newNode=new Node(data);
        if(index==0){
            addFirst(data);
            return;
        }
        size++;
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    // Remove first node in ll
    public static int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1) {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    // REmove last node in ll
    public static int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        // int val=tail.data
        int val=prev.next.data ;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    // Iterative search key in ll -> O(n)
    public static int iterativeSearchKey(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    // REcursive serach key in LL -> O(n)
    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;

    }
    public static int recursiveSearchKey(int key){
        return helper(head,key);
    }

    // Reverse a LinkedList
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    // Remove Nth Node from end of LL
    public static  void removeNthNodeFromEnd(int n){
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(n==size){
            // remove first
            head=head.next;
            return;
        }
        Node prev=head;
        int i=0;
        int idxToFind=size-n;
        while(i<idxToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }

    // Check if LL is palindrome
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        // step1 : find mid
        Node midNode= findMid(head);
        // Reverse 2nd half 
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left =head;
        // step3: check left half and right half data
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    // Detect a loop / cycle in LL
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // Remove cycle from linkedlist
    public static void removeCycle(){
        // detect cycle
        boolean cycle=false;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        // find meeting point
        // find lastNode
        Node prev=null;
        slow=head;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        // remove cycle
        prev.next=null;
    }

    // MergeSort On LinkedList

    // find mid Node
    private Node getMid(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Merge function
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return mergedLL.next;

     }
    public  Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node
        Node mid = getMid(head);

        // Split the list into two halves
        Node rightHead = mid.next;
        mid.next = null; // Split the list into two halves

        // Recursively sort both halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    // zig - zag Linked List

    public void zigZag(){
        // find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid=slow;

        // Reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // rightHead=(RH)   ;    lefttHead=(LH)
        Node LH=head;
        Node RH=prev;
        Node nextL,nextR;
        // alternate merge zigzag method
        while(LH!=null && RH!=null){
            nextL=LH.next;
            LH.next=RH;
            nextR=RH.next;
            RH.next=nextL;
            // update of LH && RH
            LH=nextL;
            RH=nextR;

        }

    }

    
    


    



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);


        // ll.addNodeAtMiddle(2, 9);
        // printLL();
        // System.out.println(size);

        // removeFirst();
        // printLL();

        // removeLast();
        // printLL();
        // System.out.println(size);
        
        // System.out.println("Key found at index : " +iterativeSearchKey(3));

        // System.out.println("Key found at index : " +recursiveSearchKey(3));

        // ll.reverse();
        // printLL();

        // removeNthNodeFromEnd(3);
        // printLL();

        // printLL();
        // System.out.println(ll.checkPalindrome());

        // System.out.println("Before sorting:");
        // ll.printLL();
        // head = ll.mergeSort(head);
        // System.out.println("After sorting:");
        // ll.printLL();

        ll.printLL();
        ll.zigZag();
        ll.printLL();
    }
}