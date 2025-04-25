import java.util.ArrayList;
import java.util.Collections;
public class ArrList_Assign2_LonelyNumbers {
    public static ArrayList<Integer> findLonelyNumbers(ArrayList<Integer>nums){
        ArrayList<Integer>lonelyNumbers=new ArrayList<>();
        // BaseCase -> if list is empty return empty list
        if(nums.isEmpty()){
            return lonelyNumbers;
        }
        // sort the list to simplify the adjacency check
        Collections.sort(nums);
        // basecase -> Handle the case where there is only one element
        if(nums.size()==1){
            lonelyNumbers.add(nums.get(0));
            return lonelyNumbers;
        }
        for(int i=0;i<nums.size();i++){
            int current =nums.get(i);
            boolean isLonely=true;
            // check if current number is lonely
            if(i>0 && nums.get(i-1)==current){
                isLonely=false;
            }
            if(i<nums.size()-1 && nums.get(i+1)==current){
                isLonely=false;
            }
            if(isLonely){
                // Check if adjacent number aare in teh list
                if(!nums.contains(current-1) && !nums.contains(current+1)){
                    lonelyNumbers.add(current);
                }
            }
        }
        return lonelyNumbers;
    }
    public static void main(String[] args) {
        ArrayList<Integer>nums=new ArrayList<>();
        nums.add(10); nums.add(5); nums.add(6); nums.add(8);
        System.out.println(findLonelyNumbers(nums));
    }
    
}
