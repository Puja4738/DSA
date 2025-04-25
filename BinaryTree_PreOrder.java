import java.util.*;
import java.util.LinkedList;
public class BinaryTree_PreOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        // Build tree     ->) O(n)
        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // PreOrder traversal      ->) O(n)
    public  static void preOrder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
        
    }

    // InOrder traversal     ->) O(n)
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // PostOrder traversal     ->) O(n)
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    // Level order traversal    ->) O(n)   s.c->O(n)
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Height of binary tree     ->) O(n)
    public static int heightTree(Node root){
        if(root==null){
            return 0;
        }
        int left_height=heightTree(root.left);
        int right_height=heightTree(root.right);
        return Math.max(left_height, right_height)+1;
    }

    // Count of all nodes in BT     ->) O(n)
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int left_count=countNodes(root.left);
        int right_count=countNodes(root.right);
        return left_count+right_count+1;
    }

    // Sum of all nodes in BT  ->) O(n)
    public static int sumNodes(Node root){
        if(root==null){
            return 0;
        }
        int left_sum=sumNodes(root.left);
        int right_sum=sumNodes(root.right);
        return left_sum+right_sum+root.data;
    }

    // Diameter of a tree :- No. of nodes in longest path b/w two leaf  ->O(n2)
    public static int diameterTree(Node root){
        if(root ==null){
            return 0;
        }
        int left_diam=diameterTree(root.left);
        int left_height=heightTree(root.left);
        int right_diam=diameterTree(root.right);
        int right_height=heightTree(root.right);

        int self_diam=left_height+right_height+1;
        return Math.max(self_diam, Math.max(left_diam,right_diam)) ;
        
    }

    //  Optimized Diameter of a tree :- No. of nodes in longest path b/w two leaf  ->O(n)
    static class Info {
        int diam;
        int height;
    
        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }
    
    public static Info optimizedDiameter(Node root) {
        if (root == null) {
            return new Info(0, 0); 
        }
        
        Info left_Info = optimizedDiameter(root.left);
        Info right_Info = optimizedDiameter(root.right);
    
        // The final diameter is the maximum of the left diameter, right diameter, or the sum of heights of left and right + 1
        int final_Diam = Math.max(Math.max(left_Info.diam, right_Info.diam), left_Info.height + right_Info.height + 1);
        
        // The final height is the maximum height of left or right subtree + 1
        int final_height = Math.max(left_Info.height, right_Info.height) + 1;
        
        return new Info(final_Diam, final_height);
    }

    // SubTree of another Tree  ->O(n)
    public static boolean isSubTree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
                        //   orrr
        // boolean leftAns=isSubTree(root.left, subRoot);
        // boolean rightAns=isSubTree(root.right, subRoot);   
        // return leftAns || rightAns   
    
    }
    public static boolean isIdentical(Node node,Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }
        else if(node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    // Top view of BinaryTree  ->O(n )    s.c ->O(n)
    static class topInfo{
        Node node;
        int hd;
        //  hd:- horizontal distance
        public topInfo(Node node , int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        Queue<topInfo>q=new LinkedList<>();
        HashMap<Integer,Node>map=new HashMap<>();

        int min=0, max=0;
        q.add(new topInfo(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            topInfo curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new topInfo(curr.node.left, curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new topInfo(curr.node.right, curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    // Kth levael of a tree using recursion  ->O(n)
    public static void kLevel(Node root,int level,int k){
        if(root==null){
            return ;
        }
        if(level==k){
            System.out.print(root.data+" ");
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }

    // Lowest common Ancestor -> Approach 1   ->O(n)  s.c ->O(n)
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();

         // Ensure both nodes exist in the tree
        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null; // Return null if either node doesn't exist in the tree
        }
        // Last common ancestor
        int i=0;
        for(;i<path1.size() && i< path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    public static boolean getPath(Node root,int n,ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean found_leftPath=getPath(root.left, n, path);
        boolean found_rightPath=getPath(root.right, n, path);

        if(found_leftPath || found_rightPath){
            return true;
        }
        // If not found in either subtree, remove the current node from the path
        path.remove(path.size()-1);
        return false;
    }

    // Lowest common Ancestor -> Approach 2  ->O(n)   s.c ->O(1)
    public static Node optimizedLCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
    
        Node left_lca = optimizedLCA(root.left, n1, n2);
        Node right_lca = optimizedLCA(root.right, n1, n2);
    
        // If both left_lca and right_lca are non-null, then this node is the LCA
        if (left_lca != null && right_lca != null) {
            return root;
        }
    
        // Otherwise, return the non-null value
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Minimum distance between nodes  ->O(n)
     public static int minDist(Node root,int n1,int n2){
        Node lca=optimizedLCA(root, n1, n2);
        int dist1=lcaDist(lca, n1);
        int dis2=lcaDist(lca, n2);
        return dist1+dis2;

     }
     public static int lcaDist(Node root , int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left_dist=lcaDist(root.left, n);
        int right_dist=lcaDist(root.right, n);
        if(left_dist==-1 && right_dist==-1){
            return -1;
        }else if(left_dist==-1){
            return right_dist+1;
        }else{
            return left_dist+1;
        }
     }

    //  Kth ancestor of a Node  ->O(n)
    public static int KthAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left_Dist=KthAncestor(root.left, n, k);
        int right_Dist=KthAncestor(root.right, n, k);

        if(left_Dist==-1 && right_Dist==-1){
            return -1;
        }
        int max=Math.max(left_Dist, right_Dist);
        if(max+1==k){
            System.out.println("The Kth ancestor : " +root.data);
        }
        return max+1;
    }

    // TransForm to sum tree  ->O(n)

    public static int transForm(Node root){
        if(root==null){
            return 0;
        }
        int left_child=transForm(root.left);
        int right_child=transForm(root.right);

        int data=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;
        root.data=newLeft+left_child+newRight+right_child;
        return data;
    }
    
    


    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();  // Create an instance of BinaryTree
        Node root = tree.buildTree(nodes);   // Build the tree using the instance
        //System.out.println("Root node data: " + root.data);

                    //        1
                    //      /    \
                    //     2      3
                    //    / \      \
                    //   4   5      6

        // preOrder(root);

        // inOrder(root);

        // postOrder(root);

        // levelOrder(root);

        // System.out.println("Height of tree : " +heightTree(root));

        // System.out.println("Total no. of count Nodes : " +countNodes(root));

        // System.out.println("The sum of all nodes : "+sumNodes(root));

        // System.out.println("Diameter of tree : "+diameterTree(root));

        // System.out.println(optimizedDiameter(root).diam);

        // Node subRoot=new Node(2);
        // subRoot.left=new Node(4);
        // subRoot.right=new Node(5);
        // if(isSubTree(root, subRoot)){
        //     System.out.println("Found subtree");
        // }else{
        //     System.out.println("Not found subtree");
        // }

        // topView(root);

        // kLevel(root, 1, 3);

    //    int n1=4,n2=6;
    //    Node lcaNode=lca(root,4,6);
    //    if (lcaNode != null) {
    //     System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lcaNode.data);
    //     } else {
    //         System.out.println("LCA not found. One or both nodes do not exist in the tree.");
    //     }

        // int n1=5,n2=6;
        // Node lcaNode = optimizedLCA(root, n1, n2);
        // if (lcaNode != null) {
        //     System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lcaNode.data);
        // } else {
        //     System.out.println("LCA not found. One or both nodes do not exist in the tree.");
        // }

        // System.out.println("The minimum distance between two nodes : " +minDist(root, 4, 6));

        // System.out.println("The Kth ancestor of level of Node : " +KthAncestor(root, 6, 1));

        System.out.println("The root data : " +transForm(root));
        System.out.println("The transform to sum tree : ");
        preOrder(root);
        
    }
}

