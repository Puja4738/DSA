import java.util.ArrayList;
public class ArrList_PairSum2 {
    public static boolean pairSum2(ArrayList<Integer>list,int target){
        // OPtimed code -> O(n)
        int n=list.size();
        int bp=-1;
        for(int i=0;i<list.size();i++){
            // braeking point
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        // smallest
        int lp=bp+1; 
        // largest  
        int rp=bp;

        while(lp!=rp){
            // case1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            // case2
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                // case3
                rp=(n+rp-1)%n;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(11);list.add(15);list.add(6);
        list.add(8);list.add(9);list.add(10);
        int target=16;
        System.out.println(pairSum2(list, target));
    }
    
}
