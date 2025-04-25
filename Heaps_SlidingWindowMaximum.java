import java.util.PriorityQueue;
public class Heaps_SlidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        public int compareTo(Pair p2){
            return p2.val-this.val;
        }
    
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int result[]=new int[arr.length-k+1];

        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }
        result[0]=pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx < (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            result[i-k+1]=pq.peek().val;
        }
        // Print result
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();

    }
    
}
