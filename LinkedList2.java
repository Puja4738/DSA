import java.util.LinkedList;
public class LinkedList2 {
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

    // Remove cycle from Linked List
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

    


    
    public static void main(String[] args) {
        LinkedList <Integer>ll =new LinkedList <> ();
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=head.next;
        System.out.println(ll);
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
        System.out.println(ll);

   
    }
}
    
