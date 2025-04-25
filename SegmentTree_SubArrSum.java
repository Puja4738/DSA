public class SegmentTree_SubArrSum {
    // Build SegmentTree   ->   O(logn)
    static int tree[];
    public static void init(int n){
        tree=new int[n*4];
    }
    public static int buildST(int arr[],int sti,int si,int sj){
        if(si==sj){
            tree[sti]=arr[si];
            return arr[si];
        }
        int mid=(si+sj)/2;
        buildST(arr, 2*sti+1, si, mid);
        buildST(arr, 2*sti+2, mid+1, sj);
        tree[sti]=tree[2*sti+1]+tree[2*sti+2];
        return tree[sti];
    }
     // Queries on  SegmentTree   ->   O(logn)
    public static int getSumQueries(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumQueriesutil(0, 0, n-1, qi, qj);
    }
    public static int getSumQueriesutil(int i,int si,int sj,int qi,int qj){
        if(qj<=si || qi>=sj){
            return 0 ;
        }else if(si>=qi && sj<=qj){
            return tree[i];
        }else{
            int mid=(si+sj)/2;
            int leftSt=getSumQueriesutil(2*i+1, si, mid, qi, qj);
            int rightSt=getSumQueriesutil(2*i+2, mid+1, sj, qi, qj);
            return leftSt+rightSt;
        }
    }
    // Update on  SegmentTree   ->   O(logn)
    public static void updateST(int arr[],int idx,int newVal){
        int n=arr.length;
        int diff=newVal-arr[idx];
        arr[idx]=newVal;
        updateStUtil(0,0,n-1,idx,diff);
    }
    public static void updateStUtil(int i,int si,int sj,int idx,int diff){
        if(idx>sj || idx<si){
            return;
        }
        if(si==sj){
            tree[i]+=diff;
        }
        if(si!=sj){
            tree[i]+=diff;
            int mid=(si+sj)/2;
            updateStUtil(2*i+1, si, mid, idx, diff);
            updateStUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }



    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buildST(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();

        System.out.println(getSumQueries(arr, 2, 5));

        updateST(arr, 2, 2);
        System.out.println(getSumQueries(arr, 2, 5));
    }
    
}
