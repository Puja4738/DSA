import java.util.*;
public class Binary_Search_Tree_Part2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
// Sorted arr to balanced BST -> O(n)
    public static Node createBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

// convert BST to balanced BST  ->O(n)

    // function of grtInorder
    public static void getInoder(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return ;
        }
        getInoder(root.left, inorder);
        inorder.add(root.data);
        getInoder(root.right, inorder);
    }
    // function of createBSt
    public static Node createBSt(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBSt(inorder, st, mid-1);
        root.right=createBSt(inorder, mid+1, end);
        return root;
    }
    public static Node balancedBST(Node root){
        // step-1    inorder sequence
        ArrayList<Integer>inorder=new ArrayList<>();
        getInoder(root,inorder);
        // step-2   inorder balanced tree
        return createBSt(inorder, 0, inorder.size() - 1);
    }

// Size of largest BST in Binary tree   ->O(n)
    public static class info {
        boolean isBST;
        int size;
        int min;
        int max;
    
        public info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    static int maxBSTsize = 0;
    
    public static info largestBST(Node root) {
        if (root == null) {
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    
        info leftinfo = largestBST(root.left);
        info rightinfo = largestBST(root.right); 
    
        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));
    
        // Check if current subtree is BST
        if (leftinfo.isBST && rightinfo.isBST && root.data > leftinfo.max && root.data < rightinfo.min) {
            maxBSTsize = Math.max(maxBSTsize, size);
            return new info(true, size, min, max);
        }
    
        return new info(false, size, min, max);
    }

// Merge two BSTs  ->O(n)

    // finction of getInorder of BSTs
    public static void getInoders(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getInoders(root.left, inorder);
        inorder.add(root.data);
        getInoders(root.right, inorder);
    }
    // Function of createBST of final sorted array 
    public static Node createBSTs(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2 ;
        Node root=new Node(inorder.get(mid));
        root.left=createBSTs(inorder, st, mid-1);
        root.right=createBSTs(inorder, mid+1, end);
        return root;
    }
    // Function of merge BSTs
    public static Node mergeBSTs(Node root1,Node root2){
        // step-1
        ArrayList<Integer>inorder1=new ArrayList<>();
        getInoders(root1, inorder1);
        // step-2
        ArrayList<Integer>inorder2=new ArrayList<>();
        getInoders(root2, inorder2);
        // step-3 merge both inorder BSTs
        int i=0,j=0;
        ArrayList<Integer>finalArr=new ArrayList<>();
        while(i<inorder1.size() && j<inorder2.size()){
            if(inorder1.get(i)<inorder2.get(j)){
                finalArr.add(inorder1.get(i));
                i++;
            }else{
                finalArr.add(inorder2.get(j));
                j++;
            }
        }
        while(i<inorder1.size()){
            finalArr.add(inorder1.get(i));
                i++;
        }
        while(j<inorder2.size()){
            finalArr.add(inorder2.get(j));
                j++;
        }
        // sorted rray -> balanced BST
        return createBSTs(finalArr, 0, finalArr.size()-1);
    }


    
    
public static void main(String[] args) {

        // int arr[]={3,5,6,8,10,11,12};
        // System.out.println("The balanced BST : ");
        // Node root=createBST(arr, 0, arr.length-1);
        // preOrder(root);

        // Node root=new Node(50);
        // root.left=new Node(30);
        // root.right=new Node(60);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);

        // root=balancedBST(root);
        // preOrder(root);

        // largestBST(root);
        // System.out.println("Size of the largest BST: " + maxBSTsize);
        // System.out.print("Preorder of the tree: ");
        // preOrder(root);

        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node root=mergeBSTs(root1, root2);
        preOrder(root);
    }
    
}
