public class LinkedList_Assign1 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    // brute force ->O(n2)
    public static Node insertionNode(Node head1,Node head2){    
        while(head2!=null){
            Node temp=head1;
            while(temp!=null){
                if(temp==head2){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }

    // optimized code -> O(n)

    public static Node optimezedInsertionNode(Node head1,Node head2){
        if(head1==null || head2==null){
            return null;
        }
        Node pointerA=head1;
        Node pointerB=head2;
        while(pointerA!=pointerB){
            if(pointerA==null){
                pointerA=head2;
            }else{
                pointerA=pointerA.next;
            }
            if(pointerB==null){
                pointerB=head1;
            }else{
                pointerB=pointerB.next;
            } 
        }
        return pointerA;
    }






    public static void main(String[] args) {
        
        Node head1=new Node(1);
        head1.next=new Node (2);
        head1.next.next=new Node (3);
        head1.next.next.next=new Node (6);
        head1.next.next.next.next=new Node (7);

        Node head2=new Node(4);
        head2.next=new Node(5);
        head2.next.next=head1.next.next.next;

        Node insertionPoint=optimezedInsertionNode(head1,head2);
        if(insertionPoint==null){
            System.out.println("No insertion Point found:");
        } else{
            System.out.println("Insertion at Node with value : " + insertionPoint.data);
        }
    }
}
