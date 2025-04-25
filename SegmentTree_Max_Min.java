public class SegmentTree_Max_Min {
    // Build MaxSegmentTree   ->   O(logn)
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int buildST(int arr[],int sti,int si,int sj){
        if(si==sj){
            tree[sti]=arr[si];
            return arr[si];
        }
        int mid=(si+sj)/2;
        buildST(arr, 2*sti+1, si, mid);
        buildST(arr, 2*sti+2, mid+1, sj);
        tree[sti]=Math.max(tree[2*sti+1],tree[2*sti+2]);
        return tree[sti];
    }
     // MaxElem Queries on  SegmentTree   ->   O(logn)
    public static int getMaxQueries(int arr[],int qi,int qj){
        int n=arr.length;
        return getMaxQueriesUtil(0,0,n-1,qi,qj);
    } 
    public static int getMaxQueriesUtil(int i,int si,int sj,int qi,int qj){
        if(qi>=sj || qj<=si){
            return 0;
        }else if(si>=qi && sj<=qj){
            return tree[i];
        }else{
            int mid=(si+sj)/2;
            int leftMax=getMaxQueriesUtil(2*i+1, si, mid, qi, qj);
            int rightMax=getMaxQueriesUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftMax,rightMax);
        }
    }
    // Update on  SegmentTree   ->   O(logn)
    public static void updateST(int arr[],int idx,int newVal){
        int n=arr.length;
        arr[idx]=newVal;
        updateStUtil(0,0,n-1,idx,newVal);
    }
    public static void updateStUtil(int i,int si,int sj,int idx,int newVal){
        if(idx>sj || idx<si){
            return;
        }
        if(si==sj){
            tree[i]=newVal;
            return;
        }
        if(si!=sj){
            tree[i]=Math.max(tree[i],newVal);
            int mid=(si+sj)/2;
            updateStUtil(2*i+1, si, mid, idx, newVal);
            updateStUtil(2*i+2, mid+1, sj, idx, newVal);
            // tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
            
        }
        
    }




    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        buildST(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();

        System.out.println(getMaxQueries(arr, 2, 5));

        updateST(arr, 4, 20);
        System.out.println(getMaxQueries(arr, 2, 5));
    }
    
}
