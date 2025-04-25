import java.util.*;
public class Heap_Operations {
    static class Heap{
        ArrayList<Integer>arr=new ArrayList<>();
// Insert ->O(logn)
        public void add(int data){
            // add at last idx
            arr.add(data);
            // child val
            int x=arr.size()-1;
            // parent val
            int par=(x-1)/2;
            while(x>0 && arr.get(x)<arr.get(par)){
                // Swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par, temp);
                // update pointer
                x=par;
                par=(x-1)/2;
            }
        }

// Get Min in heap
        public int peek(){
            return arr.get(0);
        }

// Remove from heap
        // HEAPIFY -> O(logn)
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            // Find min b/w root,left,right
            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }
            // After that swap min with root
            if(minIdx!=i){
                int temp=arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                // Again call haepify for minIdx to fix the min heap
                heapify(minIdx);
            }

        }
        
        public int remove(){
            int data=arr.get(0);
            // step1 swap first and last
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            // step2  delete last element
            arr.remove(arr.size()-1);
            // Step2  heapify -> Fix the heap
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }


    }





    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.print(h.peek() +" ");
            h.remove();
        }
        
    }
}
