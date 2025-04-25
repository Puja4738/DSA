import java.util.ArrayList;
import java.util.Collections;
public class ArrLIst_ReverseArrList {
    // O(n) -> reverse
    public static void reverse(ArrayList<Integer>list){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    // O(n) -> Maximum
    public static void maximum(ArrayList<Integer>list){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max=list.get(i);
            }
        }
        // max=Math.max(max,list.get(i));
        System.out.println("MAx element : " +max );
    }

    // O(n) -> Swap
    public static void swap(ArrayList<Integer>list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }


    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);

        // reverse(list);

        // maximum(list);

        // int idx1=1,idx2=3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // Ascending order sort
        Collections.sort(list);
        System.out.println(list);

    //    Descending order sort
     Collections.sort(list,Collections.reverseOrder());
     System.out.println(list);

                

        

        

        

        

    }
    
}
