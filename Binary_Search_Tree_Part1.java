import java.util.ArrayList;

public class Binary_Search_Tree_Part1 {
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

    // Build a BST -> O(n)
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root ;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }

    // Search in BST  ->O(H)
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key); 
        }
    }

    // Delete a Node ->O(n)
    public static Node deleteNode(Node root,int val){
        if(root.data>val){
            root.left=deleteNode(root.left, val);
        } else if(root.data<val){
            root.right=deleteNode(root.right, val);
        }else{
            // case 1 - leaf node delete
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2 - single child Node delete
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // case 3 - both child Node delete
            Node inorderSucceSSor=findInorderSuccessor(root.right);
            root.data=inorderSucceSSor.data;
            root.right=deleteNode(root.right, inorderSucceSSor.data);
        }
        return root;
    } 
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    
    // Print in range   ->O(n)
    public static void printRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data +" ");
            printRange(root.right, k1, k2);
        }else if(root.data<k1){
            printRange(root.left, k1, k2);
        }else{
            printRange(root.right, k1, k2);
        }
    }

    // Root to Leaf part  ->O(n)
    public static void printRoot2Leaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
 
    // Validate BST     ->O(n)
    public static boolean isValidateBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }else if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidateBST(root.left, min, root) && isValidateBST(root.right, root, max);
    }

    // Mirror a BST     ->O(n)
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node left_Mirror=createMirror(root.left);
        Node right_Mirror=createMirror(root.right);

        root.left=right_Mirror;
        root.right=left_Mirror;
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







    public static void main(String[] args) {
        // int values[]={5,1,3,4,2,7};
        // Node root=null;
        // for(int i=0;i<values.length;i++){
        //     root=insert(root, values[i]);
        // }
        // inOrder(root);
        // System.out.println();

        // if(search(root, 1)){
        //     System.out.println("Found");
        // }else{
        //     System.out.println("Not Found");
        // }

        // root=deleteNode(root, 5);
        // System.out.println();
        // inOrder(root);

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);
        root.right.right.right = new Node(14);

        inOrder(root);
        System.out.println();

        // System.out.println("Print in range : ");
        // printRange(root, 5, 12);

        // ArrayList<Integer> path = new ArrayList<>();
        // System.out.println("Print path from leaf to leaf : ");
        // printRoot2Leaf(root,path);

        // if(isValidateBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not Valid");
        // }

        root=createMirror(root);
        preOrder(root);
    }
    
}
